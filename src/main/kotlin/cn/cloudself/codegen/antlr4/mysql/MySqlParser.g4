/*
MySQL (Positive Technologies) grammar
The MIT License (MIT).
Copyright (c) 2015-2017, Ivan Kochurkin (kvanttt@gmail.com), Positive Technologies.
Copyright (c) 2017, Ivan Khudyashev (IHudyashov@ptsecurity.com)

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
*/

parser grammar MySqlParser;

options { tokenVocab=MySqlLexer; caseInsensitive=true; }


// Top Level Description

queryProSql
    : sqlStatement (MINUS MINUS)? SEMI?
    ;

root
    : sqlStatement (MINUS MINUS)? SEMI?
    ;

sqlStatement
    : selectStatement
    ;

// remark: NOT INCLUDED IN sqlStatement, but include in body
//  of routine's statements
compoundStatement
    : blockStatement
    | caseStatement | ifStatement | leaveStatement
    | loopStatement | repeatStatement | whileStatement
    | iterateStatement | returnStatement | cursorStatement
    ;

// details

charSet
    : CHARACTER SET
    | CHARSET
    | CHAR SET
    ;

intervalType
    : intervalTypeBase
    | YEAR | YEAR_MONTH | DAY_HOUR | DAY_MINUTE
    | DAY_SECOND | HOUR_MINUTE | HOUR_SECOND | MINUTE_SECOND
    | SECOND_MICROSECOND | MINUTE_MICROSECOND
    | HOUR_MICROSECOND | DAY_MICROSECOND
    ;

selectStatement
    : querySpecification lockClause?                                #simpleSelect
    | queryExpression lockClause?                                   #parenthesisSelect
    | querySpecificationNointo unionStatement+
        (
          UNION unionType=(ALL | DISTINCT)?
          (querySpecification | queryExpression)
        )?
        orderByClause? limitClause? lockClause?                     #unionSelect
    | queryExpressionNointo unionParenthesis+
        (
          UNION unionType=(ALL | DISTINCT)?
          queryExpression
        )?
        orderByClause? limitClause? lockClause?                     #unionParenthesisSelect
    ;


lockClause
    : FOR UPDATE | LOCK IN SHARE MODE
    ;

// details

orderByClause
    : ORDER BY orderByExpression (',' orderByExpression)*
    ;

orderByExpression
    : expression order=(ASC | DESC)?
    ;

tableSources
    : tableSource (',' tableSource)*
    ;

tableSource
    : tableSourceItem joinPart*                                     #tableSourceBase
    | '(' tableSourceItem joinPart* ')'                             #tableSourceNested
    ;

tableSourceItem
    : tableName
      (PARTITION '(' uidList ')' )? (AS? alias=uid)?
      (indexHint (',' indexHint)* )?                                #atomTableItem
    | (
      selectStatement
      | '(' parenthesisSubquery=selectStatement ')'
      )
      AS? alias=uid                                                 #subqueryTableItem
    | '(' tableSources ')'                                          #tableSourcesItem
    ;

indexHint
    : indexHintAction=(USE | IGNORE | FORCE)
      keyFormat=(INDEX|KEY) ( FOR indexHintType)?
      '(' uidList ')'
    ;

indexHintType
    : JOIN | ORDER BY | GROUP BY
    ;

joinPart
    : (INNER | CROSS)? JOIN tableSourceItem
      (
        ON expression
        | USING '(' uidList ')'
      )?                                                            #innerJoin
    | STRAIGHT_JOIN tableSourceItem (ON expression)?                #straightJoin
    | (LEFT | RIGHT) OUTER? JOIN tableSourceItem
        (
          ON expression
          | USING '(' uidList ')'
        )                                                           #outerJoin
    | NATURAL ((LEFT | RIGHT) OUTER?)? JOIN tableSourceItem         #naturalJoin
    ;

//    Select Statement's Details

queryExpression
    : '(' querySpecification ')'
    | '(' queryExpression ')'
    ;

queryExpressionNointo
    : '(' querySpecificationNointo ')'
    | '(' queryExpressionNointo ')'
    ;

querySpecification
    : SELECT selectSpec* selectElements
      fromClause? groupByClause? havingClause? windowClause? orderByClause? limitClause?
    ;

querySpecificationNointo
    : SELECT selectSpec* selectElements
      fromClause? groupByClause? havingClause? windowClause? orderByClause? limitClause?
    ;

unionParenthesis
    : UNION unionType=(ALL | DISTINCT)? queryExpressionNointo
    ;

unionStatement
    : UNION unionType=(ALL | DISTINCT)?
      (querySpecificationNointo | queryExpressionNointo)
    ;

// details

selectSpec
    : (ALL | DISTINCT | DISTINCTROW)
    | HIGH_PRIORITY | STRAIGHT_JOIN | SQL_SMALL_RESULT
    | SQL_BIG_RESULT | SQL_BUFFER_RESULT
    | (SQL_CACHE | SQL_NO_CACHE)
    | SQL_CALC_FOUND_ROWS
    ;

selectElements
    : (star='*' | selectElement ) (',' selectElement)*
    ;

selectElement
    : fullId '.' '*'                                                #selectStarElement
    | fullColumnName (AS? uid)?                                     #selectColumnElement
    | functionCall (AS? uid)?                                       #selectFunctionElement
    | (LOCAL_ID VAR_ASSIGN)? expression (AS? uid)?                  #selectExpressionElement
    ;

fromClause
    : (FROM tableSources)?
      (WHERE whereExpr=expression)?
    ;

groupByClause
    :  GROUP BY
        groupByItem (',' groupByItem)*
        (WITH ROLLUP)?
    ;

havingClause
    :  HAVING havingExpr=expression
    ;

windowClause
    :  WINDOW windowName AS '(' windowSpec ')' (',' windowName AS '(' windowSpec ')')*
    ;

groupByItem
    : expression order=(ASC | DESC)?
    ;

limitClause
    : LIMIT
    (
      (offset=limitClauseAtom ',')? limit=limitClauseAtom
      | limit=limitClauseAtom OFFSET offset=limitClauseAtom
    )
    ;

limitClauseAtom
	: decimalLiteral | mysqlVariable | simpleId
	;


// Compound Statements

routineBody
    : blockStatement | sqlStatement
    ;

// details

blockStatement
    : (uid ':')? BEGIN
      (
        (declareVariable SEMI)*
        (declareCondition SEMI)*
        (declareCursor SEMI)*
        (declareHandler SEMI)*
        procedureSqlStatement*
      )?
      END uid?
    ;

caseStatement
    : CASE (uid | expression)? caseAlternative+
      (ELSE procedureSqlStatement+)?
      END CASE
    ;

ifStatement
    : IF expression
      THEN thenStatements+=procedureSqlStatement+
      elifAlternative*
      (ELSE elseStatements+=procedureSqlStatement+ )?
      END IF
    ;

iterateStatement
    : ITERATE uid
    ;

leaveStatement
    : LEAVE uid
    ;

loopStatement
    : (uid ':')?
      LOOP procedureSqlStatement+
      END LOOP uid?
    ;

repeatStatement
    : (uid ':')?
      REPEAT procedureSqlStatement+
      UNTIL expression
      END REPEAT uid?
    ;

returnStatement
    : RETURN expression
    ;

whileStatement
    : (uid ':')?
      WHILE expression
      DO procedureSqlStatement+
      END WHILE uid?
    ;

cursorStatement
    : CLOSE uid                                                     #CloseCursor
    | FETCH (NEXT? FROM)? uid INTO uidList                          #FetchCursor
    | OPEN uid                                                      #OpenCursor
    ;

// details

declareVariable
    : DECLARE uidList dataType (DEFAULT expression)?
    ;

declareCondition
    : DECLARE uid CONDITION FOR
      ( decimalLiteral | SQLSTATE VALUE? STRING_LITERAL)
    ;

declareCursor
    : DECLARE uid CURSOR FOR selectStatement
    ;

declareHandler
    : DECLARE handlerAction=(CONTINUE | EXIT | UNDO)
      HANDLER FOR
      handlerConditionValue (',' handlerConditionValue)*
      routineBody
    ;

handlerConditionValue
    : decimalLiteral                                                #handlerConditionCode
    | SQLSTATE VALUE? STRING_LITERAL                                #handlerConditionState
    | uid                                                           #handlerConditionName
    | SQLWARNING                                                    #handlerConditionWarning
    | NOT FOUND                                                     #handlerConditionNotfound
    | SQLEXCEPTION                                                  #handlerConditionException
    ;

procedureSqlStatement
    : (compoundStatement | sqlStatement) SEMI
    ;

caseAlternative
    : WHEN (constant | expression)
      THEN procedureSqlStatement+
    ;

elifAlternative
    : ELSEIF expression
      THEN procedureSqlStatement+
    ;

// Common Clauses

//    DB Objects

fullId
    : uid (DOT_ID | '.' uid)?
    ;

tableName
    : fullId
    ;

fullColumnName
    : uid (dottedId dottedId? )?
    | . dottedId dottedId?
    ;

mysqlVariable
    : LOCAL_ID
    | GLOBAL_ID
    ;

charsetName
    : BINARY
    | charsetNameBase
    | STRING_LITERAL
    | CHARSET_REVERSE_QOUTE_STRING
    ;

collationName
    : uid | STRING_LITERAL;

engineName
    : ARCHIVE | BLACKHOLE | CSV | FEDERATED | INNODB | MEMORY
    | MRG_MYISAM | MYISAM | NDB | NDBCLUSTER | PERFORMANCE_SCHEMA
    | TOKUDB
    | ID
    | STRING_LITERAL | REVERSE_QUOTE_ID
    | CONNECT
    ;

uid
    : simpleId
    //| DOUBLE_QUOTE_ID
    | REVERSE_QUOTE_ID
    | CHARSET_REVERSE_QOUTE_STRING
    ;

simpleId
    : ID
    | charsetNameBase
    | transactionLevelBase
    | engineName
    | privilegesBase
    | intervalTypeBase
    | dataTypeBase
    | keywordsCanBeId
    | functionNameBase
    ;

dottedId
    : DOT_ID
    | '.' uid
    ;


//    Literals

decimalLiteral
    : DECIMAL_LITERAL | ZERO_DECIMAL | ONE_DECIMAL | TWO_DECIMAL | REAL_LITERAL
    ;

stringLiteral
    : (
        STRING_CHARSET_NAME? STRING_LITERAL
        | START_NATIONAL_STRING_LITERAL
      ) STRING_LITERAL+
    | (
        STRING_CHARSET_NAME? STRING_LITERAL
        | START_NATIONAL_STRING_LITERAL
      ) (COLLATE collationName)?
    ;

booleanLiteral
    : TRUE | FALSE;

hexadecimalLiteral
    : STRING_CHARSET_NAME? HEXADECIMAL_LITERAL;

nullNotnull
    : NOT? (NULL_LITERAL | NULL_SPEC_LITERAL)
    ;

constant
    : stringLiteral | decimalLiteral
    | '-' decimalLiteral
    | hexadecimalLiteral | booleanLiteral
    | REAL_LITERAL | BIT_STRING
    | NOT? nullLiteral=(NULL_LITERAL | NULL_SPEC_LITERAL)
    ;


//    Data Types

dataType
    : typeName=(
      CHAR | CHARACTER | VARCHAR | TINYTEXT | TEXT | MEDIUMTEXT | LONGTEXT
       | NCHAR | NVARCHAR | LONG
      )
      VARYING?
      lengthOneDimension? BINARY?
      (charSet charsetName)?
      (COLLATE collationName | BINARY)?                             #stringDataType
    | NATIONAL typeName=(VARCHAR | CHARACTER)
      lengthOneDimension? BINARY?                                   #nationalStringDataType
    | NCHAR typeName=VARCHAR
      lengthOneDimension? BINARY?                                   #nationalStringDataType
    | NATIONAL typeName=(CHAR | CHARACTER) VARYING
      lengthOneDimension? BINARY?                                   #nationalVaryingStringDataType
    | typeName=(
        TINYINT | SMALLINT | MEDIUMINT | INT | INTEGER | BIGINT
        | MIDDLEINT | INT1 | INT2 | INT3 | INT4 | INT8
      )
      lengthOneDimension? (SIGNED | UNSIGNED | ZEROFILL)*           #dimensionDataType
    | typeName=REAL
      lengthTwoDimension? (SIGNED | UNSIGNED | ZEROFILL)*           #dimensionDataType
    | typeName=DOUBLE PRECISION?
      lengthTwoDimension? (SIGNED | UNSIGNED | ZEROFILL)*           #dimensionDataType
    | typeName=(DECIMAL | DEC | FIXED | NUMERIC | FLOAT | FLOAT4 | FLOAT8)
      lengthTwoOptionalDimension? (SIGNED | UNSIGNED | ZEROFILL)*   #dimensionDataType
    | typeName=(
        DATE | TINYBLOB | MEDIUMBLOB | LONGBLOB
        | BOOL | BOOLEAN | SERIAL
      )                                                             #simpleDataType
    | typeName=(
        BIT | TIME | TIMESTAMP | DATETIME | BINARY
        | VARBINARY | BLOB | YEAR
      )
      lengthOneDimension?                                           #dimensionDataType
    | typeName=(ENUM | SET)
      collectionOptions BINARY?
      (charSet charsetName)?                                        #collectionDataType
    | typeName=(
        GEOMETRYCOLLECTION | GEOMCOLLECTION | LINESTRING | MULTILINESTRING
        | MULTIPOINT | MULTIPOLYGON | POINT | POLYGON | JSON | GEOMETRY
      )                                                             #spatialDataType
    | typeName=LONG VARCHAR?
      BINARY?
      (charSet charsetName)?
      (COLLATE collationName)?                                      #longVarcharDataType    // LONG VARCHAR is the same as LONG
    | LONG VARBINARY                                                #longVarbinaryDataType
    ;

collectionOptions
    : '(' STRING_LITERAL (',' STRING_LITERAL)* ')'
    ;

convertedDataType
    :
    (
      typeName=(BINARY| NCHAR) lengthOneDimension?
      | typeName=CHAR lengthOneDimension? (charSet charsetName)?
      | typeName=(DATE | DATETIME | TIME | JSON | INT | INTEGER)
      | typeName=DECIMAL lengthTwoOptionalDimension?
      | (SIGNED | UNSIGNED) INTEGER?
    ) ARRAY?
    ;

lengthOneDimension
    : '(' decimalLiteral ')'
    ;

lengthTwoDimension
    : '(' decimalLiteral ',' decimalLiteral ')'
    ;

lengthTwoOptionalDimension
    : '(' decimalLiteral (',' decimalLiteral)? ')'
    ;


//    Common Lists

uidList
    : uid (',' uid)*
    ;

expressions
    : expression (',' expression)*
    ;

//    Common Expressons

defaultValue
    : (NULL_LITERAL | unaryOperator? constant | currentTimestamp | '(' expression ')') (ON UPDATE currentTimestamp)?
    ;

currentTimestamp
    :
    (
      (CURRENT_TIMESTAMP | LOCALTIME | LOCALTIMESTAMP) ('(' decimalLiteral? ')')?
      | NOW '(' decimalLiteral? ')'
    )
    ;

//    Functions

functionCall
    : specificFunction                                              #specificFunctionCall
    | aggregateWindowedFunction                                     #aggregateFunctionCall
    | nonAggregateWindowedFunction                                  #nonAggregateFunctionCall
    | scalarFunctionName '(' functionArgs? ')'                      #scalarFunctionCall
    | fullId '(' functionArgs? ')'                                  #udfFunctionCall
    | passwordFunctionClause                                        #passwordFunctionCall
    ;

specificFunction
    : (
      CURRENT_DATE | CURRENT_TIME | CURRENT_TIMESTAMP
      | CURRENT_USER | LOCALTIME
      ) ('(' ')')?                                                  #simpleFunctionCall
    | CONVERT '(' expression separator=',' convertedDataType ')'    #dataTypeFunctionCall
    | CONVERT '(' expression USING charsetName ')'                  #dataTypeFunctionCall
    | CAST '(' expression AS convertedDataType ')'                  #dataTypeFunctionCall
    | VALUES '(' fullColumnName ')'                                 #valuesFunctionCall
    | CASE expression caseFuncAlternative+
      (ELSE elseArg=functionArg)? END                               #caseExpressionFunctionCall
    | CASE caseFuncAlternative+
      (ELSE elseArg=functionArg)? END                               #caseFunctionCall
    | CHAR '(' functionArgs  (USING charsetName)? ')'               #charFunctionCall
    | POSITION
      '('
          (
            positionString=stringLiteral
            | positionExpression=expression
          )
          IN
          (
            inString=stringLiteral
            | inExpression=expression
          )
      ')'                                                           #positionFunctionCall
    | (SUBSTR | SUBSTRING)
      '('
        (
          sourceString=stringLiteral
          | sourceExpression=expression
        ) FROM
        (
          fromDecimal=decimalLiteral
          | fromExpression=expression
        )
        (
          FOR
          (
            forDecimal=decimalLiteral
            | forExpression=expression
          )
        )?
      ')'                                                           #substrFunctionCall
    | TRIM
      '('
        positioinForm=(BOTH | LEADING | TRAILING)
        (
          sourceString=stringLiteral
          | sourceExpression=expression
        )?
        FROM
        (
          fromString=stringLiteral
          | fromExpression=expression
        )
      ')'                                                           #trimFunctionCall
    | TRIM
      '('
        (
          sourceString=stringLiteral
          | sourceExpression=expression
        )
        FROM
        (
          fromString=stringLiteral
          | fromExpression=expression
        )
      ')'                                                           #trimFunctionCall
    | WEIGHT_STRING
      '('
        (stringLiteral | expression)
        (AS stringFormat=(CHAR | BINARY)
        '(' decimalLiteral ')' )?  levelsInWeightString?
      ')'                                                           #weightFunctionCall
    | EXTRACT
      '('
        intervalType
        FROM
        (
          sourceString=stringLiteral
          | sourceExpression=expression
        )
      ')'                                                           #extractFunctionCall
    | GET_FORMAT
      '('
        datetimeFormat=(DATE | TIME | DATETIME)
        ',' stringLiteral
      ')'                                                           #getFormatFunctionCall
    | JSON_VALUE
      '(' expression
       ',' expression
         (RETURNING convertedDataType)?
         ((NULL_LITERAL | ERROR | (DEFAULT defaultValue)) ON EMPTY)?
         ((NULL_LITERAL | ERROR | (DEFAULT defaultValue)) ON ERROR)?
       ')'                                                          #jsonValueFunctionCall
    ;

caseFuncAlternative
    : WHEN condition=functionArg
      THEN consequent=functionArg
    ;

levelsInWeightString
    : LEVEL levelInWeightListElement
      (',' levelInWeightListElement)*                               #levelWeightList
    | LEVEL
      firstLevel=decimalLiteral '-' lastLevel=decimalLiteral        #levelWeightRange
    ;

levelInWeightListElement
    : decimalLiteral orderType=(ASC | DESC | REVERSE)?
    ;

aggregateWindowedFunction
    : (AVG | MAX | MIN | SUM)
      '(' aggregator=(ALL | DISTINCT)? functionArg ')' overClause?
    | COUNT '(' (starArg='*' | aggregator=ALL? functionArg | aggregator=DISTINCT functionArgs) ')' overClause?
    | (
        BIT_AND | BIT_OR | BIT_XOR | STD | STDDEV | STDDEV_POP
        | STDDEV_SAMP | VAR_POP | VAR_SAMP | VARIANCE
      ) '(' aggregator=ALL? functionArg ')' overClause?
    | GROUP_CONCAT '('
        aggregator=DISTINCT? functionArgs
        (ORDER BY
          orderByExpression (',' orderByExpression)*
        )? (SEPARATOR separator=STRING_LITERAL)?
      ')'
    ;

nonAggregateWindowedFunction
    : (LAG | LEAD) '(' expression (',' decimalLiteral)? (',' decimalLiteral)? ')' overClause
    | (FIRST_VALUE | LAST_VALUE) '(' expression ')' overClause
    | (CUME_DIST | DENSE_RANK | PERCENT_RANK | RANK | ROW_NUMBER) '('')' overClause
    | NTH_VALUE '(' expression ',' decimalLiteral ')' overClause
    | NTILE '(' decimalLiteral ')' overClause
    ;

overClause
    : OVER ('(' windowSpec? ')' | windowName)
    ;

windowSpec
    : windowName? partitionClause? orderByClause? frameClause?
    ;

windowName
    : uid
    ;

frameClause
    : frameUnits frameExtent
    ;

frameUnits
    : ROWS
    | RANGE
    ;

frameExtent
    : frameRange
    | frameBetween
    ;

frameBetween
    : BETWEEN frameRange AND frameRange
    ;

frameRange
    : CURRENT ROW
    | UNBOUNDED (PRECEDING | FOLLOWING)
    | expression (PRECEDING | FOLLOWING)
    ;

partitionClause
    : PARTITION BY expression (',' expression)*
    ;

scalarFunctionName
    : functionNameBase
    | ASCII | CURDATE | CURRENT_DATE | CURRENT_TIME
    | CURRENT_TIMESTAMP | CURTIME | DATE_ADD | DATE_SUB
    | IF | INSERT | LOCALTIME | LOCALTIMESTAMP | MID | NOW
    | REPLACE | SUBSTR | SUBSTRING | SYSDATE | TRIM
    | UTC_DATE | UTC_TIME | UTC_TIMESTAMP
    ;

passwordFunctionClause
    : functionName=(PASSWORD | OLD_PASSWORD) '(' functionArg ')'
    ;

functionArgs
    : (constant | fullColumnName | functionCall | expression)
    (
      ','
      (constant | fullColumnName | functionCall | expression)
    )*
    ;

functionArg
    : constant | fullColumnName | functionCall | expression
    ;


//    Expressions, predicates

// Simplified approach for expression
expression
    : notOperator=(NOT | '!') expression                            #notExpression
    | expression logicalOperator expression                         #logicalExpression
    | predicate IS NOT? testValue=(TRUE | FALSE | UNKNOWN)          #isExpression
    | predicate                                                     #predicateExpression
    ;

predicate
    : predicate NOT? IN '(' (selectStatement | expressions) ')'     #inPredicate
    | predicate IS nullNotnull                                      #isNullPredicate
    | left=predicate comparisonOperator right=predicate             #binaryComparisonPredicate
    | predicate comparisonOperator
      quantifier=(ALL | ANY | SOME) '(' selectStatement ')'         #subqueryComparisonPredicate
    | predicate NOT? BETWEEN predicate AND predicate                #betweenPredicate
    | predicate SOUNDS LIKE predicate                               #soundsLikePredicate
    | predicate NOT? LIKE predicate (ESCAPE STRING_LITERAL)?        #likePredicate
    | predicate NOT? regex=(REGEXP | RLIKE) predicate               #regexpPredicate
    | (LOCAL_ID VAR_ASSIGN)? expressionAtom                         #expressionAtomPredicate
    | predicate MEMBER OF '(' predicate ')'                         #jsonMemberOfPredicate
    ;


// Add in ASTVisitor nullNotnull in constant
expressionAtom
    : constant                                                      #constantExpressionAtom
    | fullColumnName                                                #fullColumnNameExpressionAtom
    | functionCall                                                  #functionCallExpressionAtom
    | expressionAtom COLLATE collationName                          #collateExpressionAtom
    | mysqlVariable                                                 #mysqlVariableExpressionAtom
    | unaryOperator expressionAtom                                  #unaryExpressionAtom
    | BINARY expressionAtom                                         #binaryExpressionAtom
    | '(' expression (',' expression)* ')'                          #nestedExpressionAtom
    | ROW '(' expression (',' expression)+ ')'                      #nestedRowExpressionAtom
    | EXISTS '(' selectStatement ')'                                #existsExpressionAtom
    | '(' selectStatement ')'                                       #subqueryExpressionAtom
    | INTERVAL expression intervalType                              #intervalExpressionAtom
    | left=expressionAtom bitOperator right=expressionAtom          #bitExpressionAtom
    | left=expressionAtom mathOperator right=expressionAtom         #mathExpressionAtom
    | left=expressionAtom jsonOperator right=expressionAtom         #jsonExpressionAtom
    ;

unaryOperator
    : '!' | '~' | '+' | '-' | NOT
    ;

comparisonOperator
    : '=' | '>' | '<' | '<' '=' | '>' '='
    | '<' '>' | '!' '=' | '<' '=' '>'
    ;

logicalOperator
    : AND | '&' '&' | XOR | OR | '|' '|'
    ;

bitOperator
    : '<' '<' | '>' '>' | '&' | '^' | '|'
    ;

mathOperator
    : '*' | '/' | '%' | DIV | MOD | '+' | '-'
    ;

jsonOperator
    : '-' '>' | '-' '>' '>'
    ;

//    Simple id sets
//     (that keyword, which can be id)

charsetNameBase
    : ARMSCII8 | ASCII | BIG5 | BINARY | CP1250 | CP1251 | CP1256 | CP1257
    | CP850 | CP852 | CP866 | CP932 | DEC8 | EUCJPMS | EUCKR
    | GB18030 | GB2312 | GBK | GEOSTD8 | GREEK | HEBREW | HP8 | KEYBCS2
    | KOI8R | KOI8U | LATIN1 | LATIN2 | LATIN5 | LATIN7 | MACCE
    | MACROMAN | SJIS | SWE7 | TIS620 | UCS2 | UJIS | UTF16
    | UTF16LE | UTF32 | UTF8 | UTF8MB3 | UTF8MB4
    ;

transactionLevelBase
    : REPEATABLE | COMMITTED | UNCOMMITTED | SERIALIZABLE
    ;

privilegesBase
    : TABLES | ROUTINE | EXECUTE | FILE | PROCESS
    | RELOAD | SHUTDOWN | SUPER | PRIVILEGES
    ;

intervalTypeBase
    : QUARTER | MONTH | DAY | HOUR
    | MINUTE | WEEK | SECOND | MICROSECOND
    ;

dataTypeBase
    : DATE | TIME | TIMESTAMP | DATETIME | YEAR | ENUM | TEXT
    ;

keywordsCanBeId
    : ACCOUNT | ACTION | ADMIN | AFTER | AGGREGATE | ALGORITHM | ANY
    | AT | AUDIT_ADMIN | AUTHORS | AUTOCOMMIT | AUTOEXTEND_SIZE
    | AUTO_INCREMENT | AVG | AVG_ROW_LENGTH | BACKUP_ADMIN | BEGIN | BINLOG | BINLOG_ADMIN | BINLOG_ENCRYPTION_ADMIN | BIT | BIT_AND | BIT_OR | BIT_XOR
    | BLOCK | BOOL | BOOLEAN | BTREE | CACHE | CASCADED | CHAIN | CHANGED
    | CHANNEL | CHECKSUM | PAGE_CHECKSUM | CATALOG_NAME | CIPHER
    | CLASS_ORIGIN | CLIENT | CLONE_ADMIN | CLOSE | CLUSTERING | COALESCE | CODE
    | COLUMNS | COLUMN_FORMAT | COLUMN_NAME | COMMENT | COMMIT | COMPACT
    | COMPLETION | COMPRESSED | COMPRESSION | CONCURRENT | CONNECT
    | CONNECTION | CONNECTION_ADMIN | CONSISTENT | CONSTRAINT_CATALOG | CONSTRAINT_NAME
    | CONSTRAINT_SCHEMA | CONTAINS | CONTEXT
    | CONTRIBUTORS | COPY | COUNT | CPU | CURRENT | CURSOR_NAME
    | DATA | DATAFILE | DEALLOCATE
    | DEFAULT_AUTH | DEFINER | DELAY_KEY_WRITE | DES_KEY_FILE | DIAGNOSTICS | DIRECTORY
    | DISABLE | DISCARD | DISK | DO | DUMPFILE | DUPLICATE
    | DYNAMIC | ENABLE | ENCRYPTION | ENCRYPTION_KEY_ADMIN | END | ENDS | ENGINE | ENGINE_ATTRIBUTE | ENGINES
    | ERROR | ERRORS | ESCAPE | EUR | EVEN | EVENT | EVENTS | EVERY | EXCEPT
    | EXCHANGE | EXCLUSIVE | EXPIRE | EXPORT | EXTENDED | EXTENT_SIZE | FAST | FAULTS
    | FIELDS | FILE_BLOCK_SIZE | FILTER | FIREWALL_ADMIN | FIREWALL_USER | FIRST | FIXED | FLUSH
    | FOLLOWS | FOUND | FULL | FUNCTION | GENERAL | GLOBAL | GRANTS | GROUP | GROUP_CONCAT
    | GROUP_REPLICATION | GROUP_REPLICATION_ADMIN | HANDLER | HASH | HELP | HOST | HOSTS | IDENTIFIED
    | IGNORED | IGNORE_SERVER_IDS | IMPORT | INDEXES | INITIAL_SIZE | INNODB_REDO_LOG_ARCHIVE
    | INPLACE | INSERT_METHOD | INSTALL | INSTANCE | INSTANT | INTERNAL | INVOKER | IO
    | IO_THREAD | IPC | ISO | ISOLATION | ISSUER | JIS | JSON | KEY_BLOCK_SIZE
    | LANGUAGE | LAST | LEAVES | LESS | LEVEL | LIST | LOCAL
    | LOGFILE | LOGS | MASTER | MASTER_AUTO_POSITION
    | MASTER_CONNECT_RETRY | MASTER_DELAY
    | MASTER_HEARTBEAT_PERIOD | MASTER_HOST | MASTER_LOG_FILE
    | MASTER_LOG_POS | MASTER_PASSWORD | MASTER_PORT
    | MASTER_RETRY_COUNT | MASTER_SSL | MASTER_SSL_CA
    | MASTER_SSL_CAPATH | MASTER_SSL_CERT | MASTER_SSL_CIPHER
    | MASTER_SSL_CRL | MASTER_SSL_CRLPATH | MASTER_SSL_KEY
    | MASTER_TLS_VERSION | MASTER_USER
    | MAX_CONNECTIONS_PER_HOUR | MAX_QUERIES_PER_HOUR
    | MAX | MAX_ROWS | MAX_SIZE | MAX_UPDATES_PER_HOUR
    | MAX_USER_CONNECTIONS | MEDIUM | MEMBER | MEMORY | MERGE | MESSAGE_TEXT
    | MID | MIGRATE
    | MIN | MIN_ROWS | MODE | MODIFY | MUTEX | MYSQL | MYSQL_ERRNO | NAME | NAMES
    | NCHAR | NDB_STORED_USER | NEVER | NEXT | NO | NOCOPY | NODEGROUP | NONE | NOWAIT | NUMBER | ODBC | OFFLINE | OFFSET
    | OF | OJ | OLD_PASSWORD | ONE | ONLINE | ONLY | OPEN | OPTIMIZER_COSTS
    | OPTIONAL | OPTIONS | ORDER | OWNER | PACK_KEYS | PAGE | PARSER | PARTIAL
    | PARTITIONING | PARTITIONS | PASSWORD | PERSIST_RO_VARIABLES_ADMIN | PHASE | PLUGINS
    | PLUGIN_DIR | PLUGIN | PORT | PRECEDES | PREPARE | PRESERVE | PREV
    | PROCESSLIST | PROFILE | PROFILES | PROXY | QUERY | QUICK
    | REBUILD | RECOVER | RECURSIVE | REDO_BUFFER_SIZE | REDUNDANT
    | RELAY | RELAYLOG | RELAY_LOG_FILE | RELAY_LOG_POS | REMOVE
    | REORGANIZE | REPAIR | REPLICATE_DO_DB | REPLICATE_DO_TABLE
    | REPLICATE_IGNORE_DB | REPLICATE_IGNORE_TABLE
    | REPLICATE_REWRITE_DB | REPLICATE_WILD_DO_TABLE
    | REPLICATE_WILD_IGNORE_TABLE | REPLICATION | REPLICATION_APPLIER | REPLICATION_SLAVE_ADMIN | RESET
    | RESOURCE_GROUP_ADMIN | RESOURCE_GROUP_USER | RESUME
    | RETURNED_SQLSTATE | RETURNS | ROLE | ROLE_ADMIN | ROLLBACK | ROLLUP | ROTATE | ROW | ROWS
    | ROW_FORMAT | RTREE | SAVEPOINT | SCHEDULE | SCHEMA_NAME | SECURITY | SECONDARY_ENGINE_ATTRIBUTE | SERIAL | SERVER
    | SESSION | SESSION_VARIABLES_ADMIN | SET_USER_ID | SHARE | SHARED | SHOW_ROUTINE | SIGNED | SIMPLE | SLAVE
    | SLOW | SNAPSHOT | SOCKET | SOME | SONAME | SOUNDS | SOURCE
    | SQL_AFTER_GTIDS | SQL_AFTER_MTS_GAPS | SQL_BEFORE_GTIDS
    | SQL_BUFFER_RESULT | SQL_CACHE | SQL_NO_CACHE | SQL_THREAD
    | STACKED | START | STARTS | STATS_AUTO_RECALC | STATS_PERSISTENT
    | STATS_SAMPLE_PAGES | STATUS | STD | STDDEV | STDDEV_POP | STDDEV_SAMP | STOP | STORAGE | STRING
    | SUBCLASS_ORIGIN | SUBJECT | SUBPARTITION | SUBPARTITIONS | SUM | SUSPEND | SWAPS
    | SWITCHES | SYSTEM_VARIABLES_ADMIN | TABLE_NAME | TABLESPACE | TABLE_ENCRYPTION_ADMIN
    | TEMPORARY | TEMPTABLE | THAN | TRADITIONAL
    | TRANSACTION | TRANSACTIONAL | TRIGGERS | TRUNCATE | UNDEFINED | UNDOFILE
    | UNDO_BUFFER_SIZE | UNINSTALL | UNKNOWN | UNTIL | UPGRADE | USA | USER | USE_FRM | USER_RESOURCES
    | VALIDATION | VALUE | VAR_POP | VAR_SAMP | VARIABLES | VARIANCE | VERSION_TOKEN_ADMIN | VIEW | WAIT | WARNINGS | WITHOUT
    | WORK | WRAPPER | X509 | XA | XA_RECOVER_ADMIN | XML
    ;

functionNameBase
    : ABS | ACOS | ADDDATE | ADDTIME | AES_DECRYPT | AES_ENCRYPT
    | AREA | ASBINARY | ASIN | ASTEXT | ASWKB | ASWKT
    | ASYMMETRIC_DECRYPT | ASYMMETRIC_DERIVE
    | ASYMMETRIC_ENCRYPT | ASYMMETRIC_SIGN | ASYMMETRIC_VERIFY
    | ATAN | ATAN2 | BENCHMARK | BIN | BIT_COUNT | BIT_LENGTH
    | BUFFER | CEIL | CEILING | CENTROID | CHARACTER_LENGTH
    | CHARSET | CHAR_LENGTH | COERCIBILITY | COLLATION
    | COMPRESS | CONCAT | CONCAT_WS | CONNECTION_ID | CONV
    | CONVERT_TZ | COS | COT | COUNT | CRC32
    | CREATE_ASYMMETRIC_PRIV_KEY | CREATE_ASYMMETRIC_PUB_KEY
    | CREATE_DH_PARAMETERS | CREATE_DIGEST | CROSSES | CUME_DIST | DATABASE | DATE
    | DATEDIFF | DATE_FORMAT | DAY | DAYNAME | DAYOFMONTH
    | DAYOFWEEK | DAYOFYEAR | DECODE | DEGREES | DENSE_RANK | DES_DECRYPT
    | DES_ENCRYPT | DIMENSION | DISJOINT | ELT | ENCODE
    | ENCRYPT | ENDPOINT | ENVELOPE | EQUALS | EXP | EXPORT_SET
    | EXTERIORRING | EXTRACTVALUE | FIELD | FIND_IN_SET | FIRST_VALUE | FLOOR
    | FORMAT | FOUND_ROWS | FROM_BASE64 | FROM_DAYS
    | FROM_UNIXTIME | GEOMCOLLFROMTEXT | GEOMCOLLFROMWKB
    | GEOMETRYCOLLECTION | GEOMETRYCOLLECTIONFROMTEXT
    | GEOMETRYCOLLECTIONFROMWKB | GEOMETRYFROMTEXT
    | GEOMETRYFROMWKB | GEOMETRYN | GEOMETRYTYPE | GEOMFROMTEXT
    | GEOMFROMWKB | GET_FORMAT | GET_LOCK | GLENGTH | GREATEST
    | GTID_SUBSET | GTID_SUBTRACT | HEX | HOUR | IFNULL
    | INET6_ATON | INET6_NTOA | INET_ATON | INET_NTOA | INSTR
    | INTERIORRINGN | INTERSECTS | INVISIBLE
    | ISCLOSED | ISEMPTY | ISNULL
    | ISSIMPLE | IS_FREE_LOCK | IS_IPV4 | IS_IPV4_COMPAT
    | IS_IPV4_MAPPED | IS_IPV6 | IS_USED_LOCK | LAG | LAST_INSERT_ID | LAST_VALUE
    | LCASE | LEAD | LEAST | LEFT | LENGTH | LINEFROMTEXT | LINEFROMWKB
    | LINESTRING | LINESTRINGFROMTEXT | LINESTRINGFROMWKB | LN
    | LOAD_FILE | LOCATE | LOG | LOG10 | LOG2 | LOWER | LPAD
    | LTRIM | MAKEDATE | MAKETIME | MAKE_SET | MASTER_POS_WAIT
    | MBRCONTAINS | MBRDISJOINT | MBREQUAL | MBRINTERSECTS
    | MBROVERLAPS | MBRTOUCHES | MBRWITHIN | MD5 | MICROSECOND
    | MINUTE | MLINEFROMTEXT | MLINEFROMWKB | MOD| MONTH | MONTHNAME
    | MPOINTFROMTEXT | MPOINTFROMWKB | MPOLYFROMTEXT
    | MPOLYFROMWKB | MULTILINESTRING | MULTILINESTRINGFROMTEXT
    | MULTILINESTRINGFROMWKB | MULTIPOINT | MULTIPOINTFROMTEXT
    | MULTIPOINTFROMWKB | MULTIPOLYGON | MULTIPOLYGONFROMTEXT
    | MULTIPOLYGONFROMWKB | NAME_CONST | NTH_VALUE | NTILE | NULLIF | NUMGEOMETRIES
    | NUMINTERIORRINGS | NUMPOINTS | OCT | OCTET_LENGTH | ORD
    | OVERLAPS | PERCENT_RANK | PERIOD_ADD | PERIOD_DIFF | PI | POINT
    | POINTFROMTEXT | POINTFROMWKB | POINTN | POLYFROMTEXT
    | POLYFROMWKB | POLYGON | POLYGONFROMTEXT | POLYGONFROMWKB
    | POSITION | POW | POWER | QUARTER | QUOTE | RADIANS | RAND | RANK
    | RANDOM_BYTES | RELEASE_LOCK | REVERSE | RIGHT | ROUND
    | ROW_COUNT | ROW_NUMBER | RPAD | RTRIM | SECOND | SEC_TO_TIME
    | SCHEMA | SESSION_USER | SESSION_VARIABLES_ADMIN
    | SHA | SHA1 | SHA2 | SIGN | SIN | SLEEP
    | SOUNDEX | SQL_THREAD_WAIT_AFTER_GTIDS | SQRT | SRID
    | STARTPOINT | STRCMP | STR_TO_DATE | ST_AREA | ST_ASBINARY
    | ST_ASTEXT | ST_ASWKB | ST_ASWKT | ST_BUFFER | ST_CENTROID
    | ST_CONTAINS | ST_CROSSES | ST_DIFFERENCE | ST_DIMENSION
    | ST_DISJOINT | ST_DISTANCE | ST_ENDPOINT | ST_ENVELOPE
    | ST_EQUALS | ST_EXTERIORRING | ST_GEOMCOLLFROMTEXT
    | ST_GEOMCOLLFROMTXT | ST_GEOMCOLLFROMWKB
    | ST_GEOMETRYCOLLECTIONFROMTEXT
    | ST_GEOMETRYCOLLECTIONFROMWKB | ST_GEOMETRYFROMTEXT
    | ST_GEOMETRYFROMWKB | ST_GEOMETRYN | ST_GEOMETRYTYPE
    | ST_GEOMFROMTEXT | ST_GEOMFROMWKB | ST_INTERIORRINGN
    | ST_INTERSECTION | ST_INTERSECTS | ST_ISCLOSED | ST_ISEMPTY
    | ST_ISSIMPLE | ST_LINEFROMTEXT | ST_LINEFROMWKB
    | ST_LINESTRINGFROMTEXT | ST_LINESTRINGFROMWKB
    | ST_NUMGEOMETRIES | ST_NUMINTERIORRING
    | ST_NUMINTERIORRINGS | ST_NUMPOINTS | ST_OVERLAPS
    | ST_POINTFROMTEXT | ST_POINTFROMWKB | ST_POINTN
    | ST_POLYFROMTEXT | ST_POLYFROMWKB | ST_POLYGONFROMTEXT
    | ST_POLYGONFROMWKB | ST_SRID | ST_STARTPOINT
    | ST_SYMDIFFERENCE | ST_TOUCHES | ST_UNION | ST_WITHIN
    | ST_X | ST_Y | SUBDATE | SUBSTRING_INDEX | SUBTIME
    | SYSTEM_USER | TAN | TIME | TIMEDIFF | TIMESTAMP
    | TIMESTAMPADD | TIMESTAMPDIFF | TIME_FORMAT | TIME_TO_SEC
    | TOUCHES | TO_BASE64 | TO_DAYS | TO_SECONDS | UCASE
    | UNCOMPRESS | UNCOMPRESSED_LENGTH | UNHEX | UNIX_TIMESTAMP
    | UPDATEXML | UPPER | UUID | UUID_SHORT
    | VALIDATE_PASSWORD_STRENGTH | VERSION | VISIBLE
    | WAIT_UNTIL_SQL_THREAD_AFTER_GTIDS | WEEK | WEEKDAY
    | WEEKOFYEAR | WEIGHT_STRING | WITHIN | YEAR | YEARWEEK
    | Y_FUNCTION | X_FUNCTION
    | JSON_ARRAY | JSON_OBJECT | JSON_QUOTE | JSON_CONTAINS | JSON_CONTAINS_PATH
    | JSON_EXTRACT | JSON_KEYS | JSON_OVERLAPS | JSON_SEARCH | JSON_VALUE
    | JSON_ARRAY_APPEND | JSON_ARRAY_INSERT | JSON_INSERT | JSON_MERGE
    | JSON_MERGE_PATCH | JSON_MERGE_PRESERVE | JSON_REMOVE | JSON_REPLACE
    | JSON_SET | JSON_UNQUOTE | JSON_DEPTH | JSON_LENGTH | JSON_TYPE
    | JSON_VALID | JSON_TABLE | JSON_SCHEMA_VALID | JSON_SCHEMA_VALIDATION_REPORT
    | JSON_PRETTY | JSON_STORAGE_FREE | JSON_STORAGE_SIZE | JSON_ARRAYAGG
    | JSON_OBJECTAGG
    ;
