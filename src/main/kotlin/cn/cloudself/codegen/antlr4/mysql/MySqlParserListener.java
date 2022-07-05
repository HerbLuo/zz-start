// Generated from /Users/herbluo/Projects/@cloudself/zz-start/src/main/kotlin/cn/cloudself/codegen/antlr4/mysql/MySqlParser.g4 by ANTLR 4.10.1
package cn.cloudself.codegen.antlr4.mysql;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MySqlParser}.
 */
public interface MySqlParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MySqlParser#queryProSql}.
	 * @param ctx the parse tree
	 */
	void enterQueryProSql(MySqlParser.QueryProSqlContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#queryProSql}.
	 * @param ctx the parse tree
	 */
	void exitQueryProSql(MySqlParser.QueryProSqlContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#root}.
	 * @param ctx the parse tree
	 */
	void enterRoot(MySqlParser.RootContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#root}.
	 * @param ctx the parse tree
	 */
	void exitRoot(MySqlParser.RootContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#sqlStatement}.
	 * @param ctx the parse tree
	 */
	void enterSqlStatement(MySqlParser.SqlStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#sqlStatement}.
	 * @param ctx the parse tree
	 */
	void exitSqlStatement(MySqlParser.SqlStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#compoundStatement}.
	 * @param ctx the parse tree
	 */
	void enterCompoundStatement(MySqlParser.CompoundStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#compoundStatement}.
	 * @param ctx the parse tree
	 */
	void exitCompoundStatement(MySqlParser.CompoundStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#charSet}.
	 * @param ctx the parse tree
	 */
	void enterCharSet(MySqlParser.CharSetContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#charSet}.
	 * @param ctx the parse tree
	 */
	void exitCharSet(MySqlParser.CharSetContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#intervalType}.
	 * @param ctx the parse tree
	 */
	void enterIntervalType(MySqlParser.IntervalTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#intervalType}.
	 * @param ctx the parse tree
	 */
	void exitIntervalType(MySqlParser.IntervalTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleSelect}
	 * labeled alternative in {@link MySqlParser#selectStatement}.
	 * @param ctx the parse tree
	 */
	void enterSimpleSelect(MySqlParser.SimpleSelectContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleSelect}
	 * labeled alternative in {@link MySqlParser#selectStatement}.
	 * @param ctx the parse tree
	 */
	void exitSimpleSelect(MySqlParser.SimpleSelectContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenthesisSelect}
	 * labeled alternative in {@link MySqlParser#selectStatement}.
	 * @param ctx the parse tree
	 */
	void enterParenthesisSelect(MySqlParser.ParenthesisSelectContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenthesisSelect}
	 * labeled alternative in {@link MySqlParser#selectStatement}.
	 * @param ctx the parse tree
	 */
	void exitParenthesisSelect(MySqlParser.ParenthesisSelectContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unionSelect}
	 * labeled alternative in {@link MySqlParser#selectStatement}.
	 * @param ctx the parse tree
	 */
	void enterUnionSelect(MySqlParser.UnionSelectContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unionSelect}
	 * labeled alternative in {@link MySqlParser#selectStatement}.
	 * @param ctx the parse tree
	 */
	void exitUnionSelect(MySqlParser.UnionSelectContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unionParenthesisSelect}
	 * labeled alternative in {@link MySqlParser#selectStatement}.
	 * @param ctx the parse tree
	 */
	void enterUnionParenthesisSelect(MySqlParser.UnionParenthesisSelectContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unionParenthesisSelect}
	 * labeled alternative in {@link MySqlParser#selectStatement}.
	 * @param ctx the parse tree
	 */
	void exitUnionParenthesisSelect(MySqlParser.UnionParenthesisSelectContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#lockClause}.
	 * @param ctx the parse tree
	 */
	void enterLockClause(MySqlParser.LockClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#lockClause}.
	 * @param ctx the parse tree
	 */
	void exitLockClause(MySqlParser.LockClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#orderByClause}.
	 * @param ctx the parse tree
	 */
	void enterOrderByClause(MySqlParser.OrderByClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#orderByClause}.
	 * @param ctx the parse tree
	 */
	void exitOrderByClause(MySqlParser.OrderByClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#orderByExpression}.
	 * @param ctx the parse tree
	 */
	void enterOrderByExpression(MySqlParser.OrderByExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#orderByExpression}.
	 * @param ctx the parse tree
	 */
	void exitOrderByExpression(MySqlParser.OrderByExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#tableSources}.
	 * @param ctx the parse tree
	 */
	void enterTableSources(MySqlParser.TableSourcesContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#tableSources}.
	 * @param ctx the parse tree
	 */
	void exitTableSources(MySqlParser.TableSourcesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tableSourceBase}
	 * labeled alternative in {@link MySqlParser#tableSource}.
	 * @param ctx the parse tree
	 */
	void enterTableSourceBase(MySqlParser.TableSourceBaseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tableSourceBase}
	 * labeled alternative in {@link MySqlParser#tableSource}.
	 * @param ctx the parse tree
	 */
	void exitTableSourceBase(MySqlParser.TableSourceBaseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tableSourceNested}
	 * labeled alternative in {@link MySqlParser#tableSource}.
	 * @param ctx the parse tree
	 */
	void enterTableSourceNested(MySqlParser.TableSourceNestedContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tableSourceNested}
	 * labeled alternative in {@link MySqlParser#tableSource}.
	 * @param ctx the parse tree
	 */
	void exitTableSourceNested(MySqlParser.TableSourceNestedContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomTableItem}
	 * labeled alternative in {@link MySqlParser#tableSourceItem}.
	 * @param ctx the parse tree
	 */
	void enterAtomTableItem(MySqlParser.AtomTableItemContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomTableItem}
	 * labeled alternative in {@link MySqlParser#tableSourceItem}.
	 * @param ctx the parse tree
	 */
	void exitAtomTableItem(MySqlParser.AtomTableItemContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subqueryTableItem}
	 * labeled alternative in {@link MySqlParser#tableSourceItem}.
	 * @param ctx the parse tree
	 */
	void enterSubqueryTableItem(MySqlParser.SubqueryTableItemContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subqueryTableItem}
	 * labeled alternative in {@link MySqlParser#tableSourceItem}.
	 * @param ctx the parse tree
	 */
	void exitSubqueryTableItem(MySqlParser.SubqueryTableItemContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tableSourcesItem}
	 * labeled alternative in {@link MySqlParser#tableSourceItem}.
	 * @param ctx the parse tree
	 */
	void enterTableSourcesItem(MySqlParser.TableSourcesItemContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tableSourcesItem}
	 * labeled alternative in {@link MySqlParser#tableSourceItem}.
	 * @param ctx the parse tree
	 */
	void exitTableSourcesItem(MySqlParser.TableSourcesItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#indexHint}.
	 * @param ctx the parse tree
	 */
	void enterIndexHint(MySqlParser.IndexHintContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#indexHint}.
	 * @param ctx the parse tree
	 */
	void exitIndexHint(MySqlParser.IndexHintContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#indexHintType}.
	 * @param ctx the parse tree
	 */
	void enterIndexHintType(MySqlParser.IndexHintTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#indexHintType}.
	 * @param ctx the parse tree
	 */
	void exitIndexHintType(MySqlParser.IndexHintTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code innerJoin}
	 * labeled alternative in {@link MySqlParser#joinPart}.
	 * @param ctx the parse tree
	 */
	void enterInnerJoin(MySqlParser.InnerJoinContext ctx);
	/**
	 * Exit a parse tree produced by the {@code innerJoin}
	 * labeled alternative in {@link MySqlParser#joinPart}.
	 * @param ctx the parse tree
	 */
	void exitInnerJoin(MySqlParser.InnerJoinContext ctx);
	/**
	 * Enter a parse tree produced by the {@code straightJoin}
	 * labeled alternative in {@link MySqlParser#joinPart}.
	 * @param ctx the parse tree
	 */
	void enterStraightJoin(MySqlParser.StraightJoinContext ctx);
	/**
	 * Exit a parse tree produced by the {@code straightJoin}
	 * labeled alternative in {@link MySqlParser#joinPart}.
	 * @param ctx the parse tree
	 */
	void exitStraightJoin(MySqlParser.StraightJoinContext ctx);
	/**
	 * Enter a parse tree produced by the {@code outerJoin}
	 * labeled alternative in {@link MySqlParser#joinPart}.
	 * @param ctx the parse tree
	 */
	void enterOuterJoin(MySqlParser.OuterJoinContext ctx);
	/**
	 * Exit a parse tree produced by the {@code outerJoin}
	 * labeled alternative in {@link MySqlParser#joinPart}.
	 * @param ctx the parse tree
	 */
	void exitOuterJoin(MySqlParser.OuterJoinContext ctx);
	/**
	 * Enter a parse tree produced by the {@code naturalJoin}
	 * labeled alternative in {@link MySqlParser#joinPart}.
	 * @param ctx the parse tree
	 */
	void enterNaturalJoin(MySqlParser.NaturalJoinContext ctx);
	/**
	 * Exit a parse tree produced by the {@code naturalJoin}
	 * labeled alternative in {@link MySqlParser#joinPart}.
	 * @param ctx the parse tree
	 */
	void exitNaturalJoin(MySqlParser.NaturalJoinContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#queryExpression}.
	 * @param ctx the parse tree
	 */
	void enterQueryExpression(MySqlParser.QueryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#queryExpression}.
	 * @param ctx the parse tree
	 */
	void exitQueryExpression(MySqlParser.QueryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#queryExpressionNointo}.
	 * @param ctx the parse tree
	 */
	void enterQueryExpressionNointo(MySqlParser.QueryExpressionNointoContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#queryExpressionNointo}.
	 * @param ctx the parse tree
	 */
	void exitQueryExpressionNointo(MySqlParser.QueryExpressionNointoContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#querySpecification}.
	 * @param ctx the parse tree
	 */
	void enterQuerySpecification(MySqlParser.QuerySpecificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#querySpecification}.
	 * @param ctx the parse tree
	 */
	void exitQuerySpecification(MySqlParser.QuerySpecificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#querySpecificationNointo}.
	 * @param ctx the parse tree
	 */
	void enterQuerySpecificationNointo(MySqlParser.QuerySpecificationNointoContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#querySpecificationNointo}.
	 * @param ctx the parse tree
	 */
	void exitQuerySpecificationNointo(MySqlParser.QuerySpecificationNointoContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#unionParenthesis}.
	 * @param ctx the parse tree
	 */
	void enterUnionParenthesis(MySqlParser.UnionParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#unionParenthesis}.
	 * @param ctx the parse tree
	 */
	void exitUnionParenthesis(MySqlParser.UnionParenthesisContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#unionStatement}.
	 * @param ctx the parse tree
	 */
	void enterUnionStatement(MySqlParser.UnionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#unionStatement}.
	 * @param ctx the parse tree
	 */
	void exitUnionStatement(MySqlParser.UnionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#selectSpec}.
	 * @param ctx the parse tree
	 */
	void enterSelectSpec(MySqlParser.SelectSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#selectSpec}.
	 * @param ctx the parse tree
	 */
	void exitSelectSpec(MySqlParser.SelectSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#selectElements}.
	 * @param ctx the parse tree
	 */
	void enterSelectElements(MySqlParser.SelectElementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#selectElements}.
	 * @param ctx the parse tree
	 */
	void exitSelectElements(MySqlParser.SelectElementsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code selectStarElement}
	 * labeled alternative in {@link MySqlParser#selectElement}.
	 * @param ctx the parse tree
	 */
	void enterSelectStarElement(MySqlParser.SelectStarElementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code selectStarElement}
	 * labeled alternative in {@link MySqlParser#selectElement}.
	 * @param ctx the parse tree
	 */
	void exitSelectStarElement(MySqlParser.SelectStarElementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code selectColumnElement}
	 * labeled alternative in {@link MySqlParser#selectElement}.
	 * @param ctx the parse tree
	 */
	void enterSelectColumnElement(MySqlParser.SelectColumnElementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code selectColumnElement}
	 * labeled alternative in {@link MySqlParser#selectElement}.
	 * @param ctx the parse tree
	 */
	void exitSelectColumnElement(MySqlParser.SelectColumnElementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code selectFunctionElement}
	 * labeled alternative in {@link MySqlParser#selectElement}.
	 * @param ctx the parse tree
	 */
	void enterSelectFunctionElement(MySqlParser.SelectFunctionElementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code selectFunctionElement}
	 * labeled alternative in {@link MySqlParser#selectElement}.
	 * @param ctx the parse tree
	 */
	void exitSelectFunctionElement(MySqlParser.SelectFunctionElementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code selectExpressionElement}
	 * labeled alternative in {@link MySqlParser#selectElement}.
	 * @param ctx the parse tree
	 */
	void enterSelectExpressionElement(MySqlParser.SelectExpressionElementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code selectExpressionElement}
	 * labeled alternative in {@link MySqlParser#selectElement}.
	 * @param ctx the parse tree
	 */
	void exitSelectExpressionElement(MySqlParser.SelectExpressionElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#fromClause}.
	 * @param ctx the parse tree
	 */
	void enterFromClause(MySqlParser.FromClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#fromClause}.
	 * @param ctx the parse tree
	 */
	void exitFromClause(MySqlParser.FromClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#groupByClause}.
	 * @param ctx the parse tree
	 */
	void enterGroupByClause(MySqlParser.GroupByClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#groupByClause}.
	 * @param ctx the parse tree
	 */
	void exitGroupByClause(MySqlParser.GroupByClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#havingClause}.
	 * @param ctx the parse tree
	 */
	void enterHavingClause(MySqlParser.HavingClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#havingClause}.
	 * @param ctx the parse tree
	 */
	void exitHavingClause(MySqlParser.HavingClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#windowClause}.
	 * @param ctx the parse tree
	 */
	void enterWindowClause(MySqlParser.WindowClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#windowClause}.
	 * @param ctx the parse tree
	 */
	void exitWindowClause(MySqlParser.WindowClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#groupByItem}.
	 * @param ctx the parse tree
	 */
	void enterGroupByItem(MySqlParser.GroupByItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#groupByItem}.
	 * @param ctx the parse tree
	 */
	void exitGroupByItem(MySqlParser.GroupByItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#limitClause}.
	 * @param ctx the parse tree
	 */
	void enterLimitClause(MySqlParser.LimitClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#limitClause}.
	 * @param ctx the parse tree
	 */
	void exitLimitClause(MySqlParser.LimitClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#limitClauseAtom}.
	 * @param ctx the parse tree
	 */
	void enterLimitClauseAtom(MySqlParser.LimitClauseAtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#limitClauseAtom}.
	 * @param ctx the parse tree
	 */
	void exitLimitClauseAtom(MySqlParser.LimitClauseAtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#routineBody}.
	 * @param ctx the parse tree
	 */
	void enterRoutineBody(MySqlParser.RoutineBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#routineBody}.
	 * @param ctx the parse tree
	 */
	void exitRoutineBody(MySqlParser.RoutineBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(MySqlParser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(MySqlParser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#caseStatement}.
	 * @param ctx the parse tree
	 */
	void enterCaseStatement(MySqlParser.CaseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#caseStatement}.
	 * @param ctx the parse tree
	 */
	void exitCaseStatement(MySqlParser.CaseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(MySqlParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(MySqlParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#iterateStatement}.
	 * @param ctx the parse tree
	 */
	void enterIterateStatement(MySqlParser.IterateStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#iterateStatement}.
	 * @param ctx the parse tree
	 */
	void exitIterateStatement(MySqlParser.IterateStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#leaveStatement}.
	 * @param ctx the parse tree
	 */
	void enterLeaveStatement(MySqlParser.LeaveStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#leaveStatement}.
	 * @param ctx the parse tree
	 */
	void exitLeaveStatement(MySqlParser.LeaveStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#loopStatement}.
	 * @param ctx the parse tree
	 */
	void enterLoopStatement(MySqlParser.LoopStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#loopStatement}.
	 * @param ctx the parse tree
	 */
	void exitLoopStatement(MySqlParser.LoopStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#repeatStatement}.
	 * @param ctx the parse tree
	 */
	void enterRepeatStatement(MySqlParser.RepeatStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#repeatStatement}.
	 * @param ctx the parse tree
	 */
	void exitRepeatStatement(MySqlParser.RepeatStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(MySqlParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(MySqlParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(MySqlParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(MySqlParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CloseCursor}
	 * labeled alternative in {@link MySqlParser#cursorStatement}.
	 * @param ctx the parse tree
	 */
	void enterCloseCursor(MySqlParser.CloseCursorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CloseCursor}
	 * labeled alternative in {@link MySqlParser#cursorStatement}.
	 * @param ctx the parse tree
	 */
	void exitCloseCursor(MySqlParser.CloseCursorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FetchCursor}
	 * labeled alternative in {@link MySqlParser#cursorStatement}.
	 * @param ctx the parse tree
	 */
	void enterFetchCursor(MySqlParser.FetchCursorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FetchCursor}
	 * labeled alternative in {@link MySqlParser#cursorStatement}.
	 * @param ctx the parse tree
	 */
	void exitFetchCursor(MySqlParser.FetchCursorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OpenCursor}
	 * labeled alternative in {@link MySqlParser#cursorStatement}.
	 * @param ctx the parse tree
	 */
	void enterOpenCursor(MySqlParser.OpenCursorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OpenCursor}
	 * labeled alternative in {@link MySqlParser#cursorStatement}.
	 * @param ctx the parse tree
	 */
	void exitOpenCursor(MySqlParser.OpenCursorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#declareVariable}.
	 * @param ctx the parse tree
	 */
	void enterDeclareVariable(MySqlParser.DeclareVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#declareVariable}.
	 * @param ctx the parse tree
	 */
	void exitDeclareVariable(MySqlParser.DeclareVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#declareCondition}.
	 * @param ctx the parse tree
	 */
	void enterDeclareCondition(MySqlParser.DeclareConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#declareCondition}.
	 * @param ctx the parse tree
	 */
	void exitDeclareCondition(MySqlParser.DeclareConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#declareCursor}.
	 * @param ctx the parse tree
	 */
	void enterDeclareCursor(MySqlParser.DeclareCursorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#declareCursor}.
	 * @param ctx the parse tree
	 */
	void exitDeclareCursor(MySqlParser.DeclareCursorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#declareHandler}.
	 * @param ctx the parse tree
	 */
	void enterDeclareHandler(MySqlParser.DeclareHandlerContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#declareHandler}.
	 * @param ctx the parse tree
	 */
	void exitDeclareHandler(MySqlParser.DeclareHandlerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code handlerConditionCode}
	 * labeled alternative in {@link MySqlParser#handlerConditionValue}.
	 * @param ctx the parse tree
	 */
	void enterHandlerConditionCode(MySqlParser.HandlerConditionCodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code handlerConditionCode}
	 * labeled alternative in {@link MySqlParser#handlerConditionValue}.
	 * @param ctx the parse tree
	 */
	void exitHandlerConditionCode(MySqlParser.HandlerConditionCodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code handlerConditionState}
	 * labeled alternative in {@link MySqlParser#handlerConditionValue}.
	 * @param ctx the parse tree
	 */
	void enterHandlerConditionState(MySqlParser.HandlerConditionStateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code handlerConditionState}
	 * labeled alternative in {@link MySqlParser#handlerConditionValue}.
	 * @param ctx the parse tree
	 */
	void exitHandlerConditionState(MySqlParser.HandlerConditionStateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code handlerConditionName}
	 * labeled alternative in {@link MySqlParser#handlerConditionValue}.
	 * @param ctx the parse tree
	 */
	void enterHandlerConditionName(MySqlParser.HandlerConditionNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code handlerConditionName}
	 * labeled alternative in {@link MySqlParser#handlerConditionValue}.
	 * @param ctx the parse tree
	 */
	void exitHandlerConditionName(MySqlParser.HandlerConditionNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code handlerConditionWarning}
	 * labeled alternative in {@link MySqlParser#handlerConditionValue}.
	 * @param ctx the parse tree
	 */
	void enterHandlerConditionWarning(MySqlParser.HandlerConditionWarningContext ctx);
	/**
	 * Exit a parse tree produced by the {@code handlerConditionWarning}
	 * labeled alternative in {@link MySqlParser#handlerConditionValue}.
	 * @param ctx the parse tree
	 */
	void exitHandlerConditionWarning(MySqlParser.HandlerConditionWarningContext ctx);
	/**
	 * Enter a parse tree produced by the {@code handlerConditionNotfound}
	 * labeled alternative in {@link MySqlParser#handlerConditionValue}.
	 * @param ctx the parse tree
	 */
	void enterHandlerConditionNotfound(MySqlParser.HandlerConditionNotfoundContext ctx);
	/**
	 * Exit a parse tree produced by the {@code handlerConditionNotfound}
	 * labeled alternative in {@link MySqlParser#handlerConditionValue}.
	 * @param ctx the parse tree
	 */
	void exitHandlerConditionNotfound(MySqlParser.HandlerConditionNotfoundContext ctx);
	/**
	 * Enter a parse tree produced by the {@code handlerConditionException}
	 * labeled alternative in {@link MySqlParser#handlerConditionValue}.
	 * @param ctx the parse tree
	 */
	void enterHandlerConditionException(MySqlParser.HandlerConditionExceptionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code handlerConditionException}
	 * labeled alternative in {@link MySqlParser#handlerConditionValue}.
	 * @param ctx the parse tree
	 */
	void exitHandlerConditionException(MySqlParser.HandlerConditionExceptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#procedureSqlStatement}.
	 * @param ctx the parse tree
	 */
	void enterProcedureSqlStatement(MySqlParser.ProcedureSqlStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#procedureSqlStatement}.
	 * @param ctx the parse tree
	 */
	void exitProcedureSqlStatement(MySqlParser.ProcedureSqlStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#caseAlternative}.
	 * @param ctx the parse tree
	 */
	void enterCaseAlternative(MySqlParser.CaseAlternativeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#caseAlternative}.
	 * @param ctx the parse tree
	 */
	void exitCaseAlternative(MySqlParser.CaseAlternativeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#elifAlternative}.
	 * @param ctx the parse tree
	 */
	void enterElifAlternative(MySqlParser.ElifAlternativeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#elifAlternative}.
	 * @param ctx the parse tree
	 */
	void exitElifAlternative(MySqlParser.ElifAlternativeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#fullId}.
	 * @param ctx the parse tree
	 */
	void enterFullId(MySqlParser.FullIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#fullId}.
	 * @param ctx the parse tree
	 */
	void exitFullId(MySqlParser.FullIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#tableName}.
	 * @param ctx the parse tree
	 */
	void enterTableName(MySqlParser.TableNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#tableName}.
	 * @param ctx the parse tree
	 */
	void exitTableName(MySqlParser.TableNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#fullColumnName}.
	 * @param ctx the parse tree
	 */
	void enterFullColumnName(MySqlParser.FullColumnNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#fullColumnName}.
	 * @param ctx the parse tree
	 */
	void exitFullColumnName(MySqlParser.FullColumnNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#mysqlVariable}.
	 * @param ctx the parse tree
	 */
	void enterMysqlVariable(MySqlParser.MysqlVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#mysqlVariable}.
	 * @param ctx the parse tree
	 */
	void exitMysqlVariable(MySqlParser.MysqlVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#charsetName}.
	 * @param ctx the parse tree
	 */
	void enterCharsetName(MySqlParser.CharsetNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#charsetName}.
	 * @param ctx the parse tree
	 */
	void exitCharsetName(MySqlParser.CharsetNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#collationName}.
	 * @param ctx the parse tree
	 */
	void enterCollationName(MySqlParser.CollationNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#collationName}.
	 * @param ctx the parse tree
	 */
	void exitCollationName(MySqlParser.CollationNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#engineName}.
	 * @param ctx the parse tree
	 */
	void enterEngineName(MySqlParser.EngineNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#engineName}.
	 * @param ctx the parse tree
	 */
	void exitEngineName(MySqlParser.EngineNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#uid}.
	 * @param ctx the parse tree
	 */
	void enterUid(MySqlParser.UidContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#uid}.
	 * @param ctx the parse tree
	 */
	void exitUid(MySqlParser.UidContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#simpleId}.
	 * @param ctx the parse tree
	 */
	void enterSimpleId(MySqlParser.SimpleIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#simpleId}.
	 * @param ctx the parse tree
	 */
	void exitSimpleId(MySqlParser.SimpleIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#dottedId}.
	 * @param ctx the parse tree
	 */
	void enterDottedId(MySqlParser.DottedIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#dottedId}.
	 * @param ctx the parse tree
	 */
	void exitDottedId(MySqlParser.DottedIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#decimalLiteral}.
	 * @param ctx the parse tree
	 */
	void enterDecimalLiteral(MySqlParser.DecimalLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#decimalLiteral}.
	 * @param ctx the parse tree
	 */
	void exitDecimalLiteral(MySqlParser.DecimalLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(MySqlParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(MySqlParser.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void enterBooleanLiteral(MySqlParser.BooleanLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void exitBooleanLiteral(MySqlParser.BooleanLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#hexadecimalLiteral}.
	 * @param ctx the parse tree
	 */
	void enterHexadecimalLiteral(MySqlParser.HexadecimalLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#hexadecimalLiteral}.
	 * @param ctx the parse tree
	 */
	void exitHexadecimalLiteral(MySqlParser.HexadecimalLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#nullNotnull}.
	 * @param ctx the parse tree
	 */
	void enterNullNotnull(MySqlParser.NullNotnullContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#nullNotnull}.
	 * @param ctx the parse tree
	 */
	void exitNullNotnull(MySqlParser.NullNotnullContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(MySqlParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(MySqlParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringDataType}
	 * labeled alternative in {@link MySqlParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterStringDataType(MySqlParser.StringDataTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringDataType}
	 * labeled alternative in {@link MySqlParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitStringDataType(MySqlParser.StringDataTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nationalStringDataType}
	 * labeled alternative in {@link MySqlParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterNationalStringDataType(MySqlParser.NationalStringDataTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nationalStringDataType}
	 * labeled alternative in {@link MySqlParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitNationalStringDataType(MySqlParser.NationalStringDataTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nationalVaryingStringDataType}
	 * labeled alternative in {@link MySqlParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterNationalVaryingStringDataType(MySqlParser.NationalVaryingStringDataTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nationalVaryingStringDataType}
	 * labeled alternative in {@link MySqlParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitNationalVaryingStringDataType(MySqlParser.NationalVaryingStringDataTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dimensionDataType}
	 * labeled alternative in {@link MySqlParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterDimensionDataType(MySqlParser.DimensionDataTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dimensionDataType}
	 * labeled alternative in {@link MySqlParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitDimensionDataType(MySqlParser.DimensionDataTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleDataType}
	 * labeled alternative in {@link MySqlParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterSimpleDataType(MySqlParser.SimpleDataTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleDataType}
	 * labeled alternative in {@link MySqlParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitSimpleDataType(MySqlParser.SimpleDataTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code collectionDataType}
	 * labeled alternative in {@link MySqlParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterCollectionDataType(MySqlParser.CollectionDataTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code collectionDataType}
	 * labeled alternative in {@link MySqlParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitCollectionDataType(MySqlParser.CollectionDataTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code spatialDataType}
	 * labeled alternative in {@link MySqlParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterSpatialDataType(MySqlParser.SpatialDataTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code spatialDataType}
	 * labeled alternative in {@link MySqlParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitSpatialDataType(MySqlParser.SpatialDataTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code longVarcharDataType}
	 * labeled alternative in {@link MySqlParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterLongVarcharDataType(MySqlParser.LongVarcharDataTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code longVarcharDataType}
	 * labeled alternative in {@link MySqlParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitLongVarcharDataType(MySqlParser.LongVarcharDataTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code longVarbinaryDataType}
	 * labeled alternative in {@link MySqlParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterLongVarbinaryDataType(MySqlParser.LongVarbinaryDataTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code longVarbinaryDataType}
	 * labeled alternative in {@link MySqlParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitLongVarbinaryDataType(MySqlParser.LongVarbinaryDataTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#collectionOptions}.
	 * @param ctx the parse tree
	 */
	void enterCollectionOptions(MySqlParser.CollectionOptionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#collectionOptions}.
	 * @param ctx the parse tree
	 */
	void exitCollectionOptions(MySqlParser.CollectionOptionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#convertedDataType}.
	 * @param ctx the parse tree
	 */
	void enterConvertedDataType(MySqlParser.ConvertedDataTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#convertedDataType}.
	 * @param ctx the parse tree
	 */
	void exitConvertedDataType(MySqlParser.ConvertedDataTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#lengthOneDimension}.
	 * @param ctx the parse tree
	 */
	void enterLengthOneDimension(MySqlParser.LengthOneDimensionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#lengthOneDimension}.
	 * @param ctx the parse tree
	 */
	void exitLengthOneDimension(MySqlParser.LengthOneDimensionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#lengthTwoDimension}.
	 * @param ctx the parse tree
	 */
	void enterLengthTwoDimension(MySqlParser.LengthTwoDimensionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#lengthTwoDimension}.
	 * @param ctx the parse tree
	 */
	void exitLengthTwoDimension(MySqlParser.LengthTwoDimensionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#lengthTwoOptionalDimension}.
	 * @param ctx the parse tree
	 */
	void enterLengthTwoOptionalDimension(MySqlParser.LengthTwoOptionalDimensionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#lengthTwoOptionalDimension}.
	 * @param ctx the parse tree
	 */
	void exitLengthTwoOptionalDimension(MySqlParser.LengthTwoOptionalDimensionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#uidList}.
	 * @param ctx the parse tree
	 */
	void enterUidList(MySqlParser.UidListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#uidList}.
	 * @param ctx the parse tree
	 */
	void exitUidList(MySqlParser.UidListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#expressions}.
	 * @param ctx the parse tree
	 */
	void enterExpressions(MySqlParser.ExpressionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#expressions}.
	 * @param ctx the parse tree
	 */
	void exitExpressions(MySqlParser.ExpressionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#defaultValue}.
	 * @param ctx the parse tree
	 */
	void enterDefaultValue(MySqlParser.DefaultValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#defaultValue}.
	 * @param ctx the parse tree
	 */
	void exitDefaultValue(MySqlParser.DefaultValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#currentTimestamp}.
	 * @param ctx the parse tree
	 */
	void enterCurrentTimestamp(MySqlParser.CurrentTimestampContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#currentTimestamp}.
	 * @param ctx the parse tree
	 */
	void exitCurrentTimestamp(MySqlParser.CurrentTimestampContext ctx);
	/**
	 * Enter a parse tree produced by the {@code specificFunctionCall}
	 * labeled alternative in {@link MySqlParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterSpecificFunctionCall(MySqlParser.SpecificFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code specificFunctionCall}
	 * labeled alternative in {@link MySqlParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitSpecificFunctionCall(MySqlParser.SpecificFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code aggregateFunctionCall}
	 * labeled alternative in {@link MySqlParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterAggregateFunctionCall(MySqlParser.AggregateFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code aggregateFunctionCall}
	 * labeled alternative in {@link MySqlParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitAggregateFunctionCall(MySqlParser.AggregateFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nonAggregateFunctionCall}
	 * labeled alternative in {@link MySqlParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterNonAggregateFunctionCall(MySqlParser.NonAggregateFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nonAggregateFunctionCall}
	 * labeled alternative in {@link MySqlParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitNonAggregateFunctionCall(MySqlParser.NonAggregateFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code scalarFunctionCall}
	 * labeled alternative in {@link MySqlParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterScalarFunctionCall(MySqlParser.ScalarFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code scalarFunctionCall}
	 * labeled alternative in {@link MySqlParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitScalarFunctionCall(MySqlParser.ScalarFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code udfFunctionCall}
	 * labeled alternative in {@link MySqlParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterUdfFunctionCall(MySqlParser.UdfFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code udfFunctionCall}
	 * labeled alternative in {@link MySqlParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitUdfFunctionCall(MySqlParser.UdfFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code passwordFunctionCall}
	 * labeled alternative in {@link MySqlParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterPasswordFunctionCall(MySqlParser.PasswordFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code passwordFunctionCall}
	 * labeled alternative in {@link MySqlParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitPasswordFunctionCall(MySqlParser.PasswordFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleFunctionCall}
	 * labeled alternative in {@link MySqlParser#specificFunction}.
	 * @param ctx the parse tree
	 */
	void enterSimpleFunctionCall(MySqlParser.SimpleFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleFunctionCall}
	 * labeled alternative in {@link MySqlParser#specificFunction}.
	 * @param ctx the parse tree
	 */
	void exitSimpleFunctionCall(MySqlParser.SimpleFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dataTypeFunctionCall}
	 * labeled alternative in {@link MySqlParser#specificFunction}.
	 * @param ctx the parse tree
	 */
	void enterDataTypeFunctionCall(MySqlParser.DataTypeFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dataTypeFunctionCall}
	 * labeled alternative in {@link MySqlParser#specificFunction}.
	 * @param ctx the parse tree
	 */
	void exitDataTypeFunctionCall(MySqlParser.DataTypeFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valuesFunctionCall}
	 * labeled alternative in {@link MySqlParser#specificFunction}.
	 * @param ctx the parse tree
	 */
	void enterValuesFunctionCall(MySqlParser.ValuesFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valuesFunctionCall}
	 * labeled alternative in {@link MySqlParser#specificFunction}.
	 * @param ctx the parse tree
	 */
	void exitValuesFunctionCall(MySqlParser.ValuesFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code caseExpressionFunctionCall}
	 * labeled alternative in {@link MySqlParser#specificFunction}.
	 * @param ctx the parse tree
	 */
	void enterCaseExpressionFunctionCall(MySqlParser.CaseExpressionFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code caseExpressionFunctionCall}
	 * labeled alternative in {@link MySqlParser#specificFunction}.
	 * @param ctx the parse tree
	 */
	void exitCaseExpressionFunctionCall(MySqlParser.CaseExpressionFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code caseFunctionCall}
	 * labeled alternative in {@link MySqlParser#specificFunction}.
	 * @param ctx the parse tree
	 */
	void enterCaseFunctionCall(MySqlParser.CaseFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code caseFunctionCall}
	 * labeled alternative in {@link MySqlParser#specificFunction}.
	 * @param ctx the parse tree
	 */
	void exitCaseFunctionCall(MySqlParser.CaseFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code charFunctionCall}
	 * labeled alternative in {@link MySqlParser#specificFunction}.
	 * @param ctx the parse tree
	 */
	void enterCharFunctionCall(MySqlParser.CharFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code charFunctionCall}
	 * labeled alternative in {@link MySqlParser#specificFunction}.
	 * @param ctx the parse tree
	 */
	void exitCharFunctionCall(MySqlParser.CharFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code positionFunctionCall}
	 * labeled alternative in {@link MySqlParser#specificFunction}.
	 * @param ctx the parse tree
	 */
	void enterPositionFunctionCall(MySqlParser.PositionFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code positionFunctionCall}
	 * labeled alternative in {@link MySqlParser#specificFunction}.
	 * @param ctx the parse tree
	 */
	void exitPositionFunctionCall(MySqlParser.PositionFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code substrFunctionCall}
	 * labeled alternative in {@link MySqlParser#specificFunction}.
	 * @param ctx the parse tree
	 */
	void enterSubstrFunctionCall(MySqlParser.SubstrFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code substrFunctionCall}
	 * labeled alternative in {@link MySqlParser#specificFunction}.
	 * @param ctx the parse tree
	 */
	void exitSubstrFunctionCall(MySqlParser.SubstrFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code trimFunctionCall}
	 * labeled alternative in {@link MySqlParser#specificFunction}.
	 * @param ctx the parse tree
	 */
	void enterTrimFunctionCall(MySqlParser.TrimFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code trimFunctionCall}
	 * labeled alternative in {@link MySqlParser#specificFunction}.
	 * @param ctx the parse tree
	 */
	void exitTrimFunctionCall(MySqlParser.TrimFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code weightFunctionCall}
	 * labeled alternative in {@link MySqlParser#specificFunction}.
	 * @param ctx the parse tree
	 */
	void enterWeightFunctionCall(MySqlParser.WeightFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code weightFunctionCall}
	 * labeled alternative in {@link MySqlParser#specificFunction}.
	 * @param ctx the parse tree
	 */
	void exitWeightFunctionCall(MySqlParser.WeightFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code extractFunctionCall}
	 * labeled alternative in {@link MySqlParser#specificFunction}.
	 * @param ctx the parse tree
	 */
	void enterExtractFunctionCall(MySqlParser.ExtractFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code extractFunctionCall}
	 * labeled alternative in {@link MySqlParser#specificFunction}.
	 * @param ctx the parse tree
	 */
	void exitExtractFunctionCall(MySqlParser.ExtractFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code getFormatFunctionCall}
	 * labeled alternative in {@link MySqlParser#specificFunction}.
	 * @param ctx the parse tree
	 */
	void enterGetFormatFunctionCall(MySqlParser.GetFormatFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code getFormatFunctionCall}
	 * labeled alternative in {@link MySqlParser#specificFunction}.
	 * @param ctx the parse tree
	 */
	void exitGetFormatFunctionCall(MySqlParser.GetFormatFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code jsonValueFunctionCall}
	 * labeled alternative in {@link MySqlParser#specificFunction}.
	 * @param ctx the parse tree
	 */
	void enterJsonValueFunctionCall(MySqlParser.JsonValueFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code jsonValueFunctionCall}
	 * labeled alternative in {@link MySqlParser#specificFunction}.
	 * @param ctx the parse tree
	 */
	void exitJsonValueFunctionCall(MySqlParser.JsonValueFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#caseFuncAlternative}.
	 * @param ctx the parse tree
	 */
	void enterCaseFuncAlternative(MySqlParser.CaseFuncAlternativeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#caseFuncAlternative}.
	 * @param ctx the parse tree
	 */
	void exitCaseFuncAlternative(MySqlParser.CaseFuncAlternativeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code levelWeightList}
	 * labeled alternative in {@link MySqlParser#levelsInWeightString}.
	 * @param ctx the parse tree
	 */
	void enterLevelWeightList(MySqlParser.LevelWeightListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code levelWeightList}
	 * labeled alternative in {@link MySqlParser#levelsInWeightString}.
	 * @param ctx the parse tree
	 */
	void exitLevelWeightList(MySqlParser.LevelWeightListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code levelWeightRange}
	 * labeled alternative in {@link MySqlParser#levelsInWeightString}.
	 * @param ctx the parse tree
	 */
	void enterLevelWeightRange(MySqlParser.LevelWeightRangeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code levelWeightRange}
	 * labeled alternative in {@link MySqlParser#levelsInWeightString}.
	 * @param ctx the parse tree
	 */
	void exitLevelWeightRange(MySqlParser.LevelWeightRangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#levelInWeightListElement}.
	 * @param ctx the parse tree
	 */
	void enterLevelInWeightListElement(MySqlParser.LevelInWeightListElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#levelInWeightListElement}.
	 * @param ctx the parse tree
	 */
	void exitLevelInWeightListElement(MySqlParser.LevelInWeightListElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#aggregateWindowedFunction}.
	 * @param ctx the parse tree
	 */
	void enterAggregateWindowedFunction(MySqlParser.AggregateWindowedFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#aggregateWindowedFunction}.
	 * @param ctx the parse tree
	 */
	void exitAggregateWindowedFunction(MySqlParser.AggregateWindowedFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#nonAggregateWindowedFunction}.
	 * @param ctx the parse tree
	 */
	void enterNonAggregateWindowedFunction(MySqlParser.NonAggregateWindowedFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#nonAggregateWindowedFunction}.
	 * @param ctx the parse tree
	 */
	void exitNonAggregateWindowedFunction(MySqlParser.NonAggregateWindowedFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#overClause}.
	 * @param ctx the parse tree
	 */
	void enterOverClause(MySqlParser.OverClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#overClause}.
	 * @param ctx the parse tree
	 */
	void exitOverClause(MySqlParser.OverClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#windowSpec}.
	 * @param ctx the parse tree
	 */
	void enterWindowSpec(MySqlParser.WindowSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#windowSpec}.
	 * @param ctx the parse tree
	 */
	void exitWindowSpec(MySqlParser.WindowSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#windowName}.
	 * @param ctx the parse tree
	 */
	void enterWindowName(MySqlParser.WindowNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#windowName}.
	 * @param ctx the parse tree
	 */
	void exitWindowName(MySqlParser.WindowNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#frameClause}.
	 * @param ctx the parse tree
	 */
	void enterFrameClause(MySqlParser.FrameClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#frameClause}.
	 * @param ctx the parse tree
	 */
	void exitFrameClause(MySqlParser.FrameClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#frameUnits}.
	 * @param ctx the parse tree
	 */
	void enterFrameUnits(MySqlParser.FrameUnitsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#frameUnits}.
	 * @param ctx the parse tree
	 */
	void exitFrameUnits(MySqlParser.FrameUnitsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#frameExtent}.
	 * @param ctx the parse tree
	 */
	void enterFrameExtent(MySqlParser.FrameExtentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#frameExtent}.
	 * @param ctx the parse tree
	 */
	void exitFrameExtent(MySqlParser.FrameExtentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#frameBetween}.
	 * @param ctx the parse tree
	 */
	void enterFrameBetween(MySqlParser.FrameBetweenContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#frameBetween}.
	 * @param ctx the parse tree
	 */
	void exitFrameBetween(MySqlParser.FrameBetweenContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#frameRange}.
	 * @param ctx the parse tree
	 */
	void enterFrameRange(MySqlParser.FrameRangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#frameRange}.
	 * @param ctx the parse tree
	 */
	void exitFrameRange(MySqlParser.FrameRangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#partitionClause}.
	 * @param ctx the parse tree
	 */
	void enterPartitionClause(MySqlParser.PartitionClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#partitionClause}.
	 * @param ctx the parse tree
	 */
	void exitPartitionClause(MySqlParser.PartitionClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#scalarFunctionName}.
	 * @param ctx the parse tree
	 */
	void enterScalarFunctionName(MySqlParser.ScalarFunctionNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#scalarFunctionName}.
	 * @param ctx the parse tree
	 */
	void exitScalarFunctionName(MySqlParser.ScalarFunctionNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#passwordFunctionClause}.
	 * @param ctx the parse tree
	 */
	void enterPasswordFunctionClause(MySqlParser.PasswordFunctionClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#passwordFunctionClause}.
	 * @param ctx the parse tree
	 */
	void exitPasswordFunctionClause(MySqlParser.PasswordFunctionClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#functionArgs}.
	 * @param ctx the parse tree
	 */
	void enterFunctionArgs(MySqlParser.FunctionArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#functionArgs}.
	 * @param ctx the parse tree
	 */
	void exitFunctionArgs(MySqlParser.FunctionArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#functionArg}.
	 * @param ctx the parse tree
	 */
	void enterFunctionArg(MySqlParser.FunctionArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#functionArg}.
	 * @param ctx the parse tree
	 */
	void exitFunctionArg(MySqlParser.FunctionArgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code isExpression}
	 * labeled alternative in {@link MySqlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIsExpression(MySqlParser.IsExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code isExpression}
	 * labeled alternative in {@link MySqlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIsExpression(MySqlParser.IsExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link MySqlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpression(MySqlParser.NotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link MySqlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpression(MySqlParser.NotExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicalExpression}
	 * labeled alternative in {@link MySqlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalExpression(MySqlParser.LogicalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicalExpression}
	 * labeled alternative in {@link MySqlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalExpression(MySqlParser.LogicalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code predicateExpression}
	 * labeled alternative in {@link MySqlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPredicateExpression(MySqlParser.PredicateExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code predicateExpression}
	 * labeled alternative in {@link MySqlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPredicateExpression(MySqlParser.PredicateExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code soundsLikePredicate}
	 * labeled alternative in {@link MySqlParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterSoundsLikePredicate(MySqlParser.SoundsLikePredicateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code soundsLikePredicate}
	 * labeled alternative in {@link MySqlParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitSoundsLikePredicate(MySqlParser.SoundsLikePredicateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionAtomPredicate}
	 * labeled alternative in {@link MySqlParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterExpressionAtomPredicate(MySqlParser.ExpressionAtomPredicateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionAtomPredicate}
	 * labeled alternative in {@link MySqlParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitExpressionAtomPredicate(MySqlParser.ExpressionAtomPredicateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subqueryComparisonPredicate}
	 * labeled alternative in {@link MySqlParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterSubqueryComparisonPredicate(MySqlParser.SubqueryComparisonPredicateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subqueryComparisonPredicate}
	 * labeled alternative in {@link MySqlParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitSubqueryComparisonPredicate(MySqlParser.SubqueryComparisonPredicateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code jsonMemberOfPredicate}
	 * labeled alternative in {@link MySqlParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterJsonMemberOfPredicate(MySqlParser.JsonMemberOfPredicateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code jsonMemberOfPredicate}
	 * labeled alternative in {@link MySqlParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitJsonMemberOfPredicate(MySqlParser.JsonMemberOfPredicateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryComparisonPredicate}
	 * labeled alternative in {@link MySqlParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterBinaryComparisonPredicate(MySqlParser.BinaryComparisonPredicateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryComparisonPredicate}
	 * labeled alternative in {@link MySqlParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitBinaryComparisonPredicate(MySqlParser.BinaryComparisonPredicateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inPredicate}
	 * labeled alternative in {@link MySqlParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterInPredicate(MySqlParser.InPredicateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inPredicate}
	 * labeled alternative in {@link MySqlParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitInPredicate(MySqlParser.InPredicateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code betweenPredicate}
	 * labeled alternative in {@link MySqlParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterBetweenPredicate(MySqlParser.BetweenPredicateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code betweenPredicate}
	 * labeled alternative in {@link MySqlParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitBetweenPredicate(MySqlParser.BetweenPredicateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code isNullPredicate}
	 * labeled alternative in {@link MySqlParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterIsNullPredicate(MySqlParser.IsNullPredicateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code isNullPredicate}
	 * labeled alternative in {@link MySqlParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitIsNullPredicate(MySqlParser.IsNullPredicateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code likePredicate}
	 * labeled alternative in {@link MySqlParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterLikePredicate(MySqlParser.LikePredicateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code likePredicate}
	 * labeled alternative in {@link MySqlParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitLikePredicate(MySqlParser.LikePredicateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code regexpPredicate}
	 * labeled alternative in {@link MySqlParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterRegexpPredicate(MySqlParser.RegexpPredicateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code regexpPredicate}
	 * labeled alternative in {@link MySqlParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitRegexpPredicate(MySqlParser.RegexpPredicateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expressionAtom}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpressionAtom(MySqlParser.UnaryExpressionAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expressionAtom}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpressionAtom(MySqlParser.UnaryExpressionAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code collateExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expressionAtom}.
	 * @param ctx the parse tree
	 */
	void enterCollateExpressionAtom(MySqlParser.CollateExpressionAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code collateExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expressionAtom}.
	 * @param ctx the parse tree
	 */
	void exitCollateExpressionAtom(MySqlParser.CollateExpressionAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mysqlVariableExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expressionAtom}.
	 * @param ctx the parse tree
	 */
	void enterMysqlVariableExpressionAtom(MySqlParser.MysqlVariableExpressionAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mysqlVariableExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expressionAtom}.
	 * @param ctx the parse tree
	 */
	void exitMysqlVariableExpressionAtom(MySqlParser.MysqlVariableExpressionAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nestedExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expressionAtom}.
	 * @param ctx the parse tree
	 */
	void enterNestedExpressionAtom(MySqlParser.NestedExpressionAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nestedExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expressionAtom}.
	 * @param ctx the parse tree
	 */
	void exitNestedExpressionAtom(MySqlParser.NestedExpressionAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nestedRowExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expressionAtom}.
	 * @param ctx the parse tree
	 */
	void enterNestedRowExpressionAtom(MySqlParser.NestedRowExpressionAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nestedRowExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expressionAtom}.
	 * @param ctx the parse tree
	 */
	void exitNestedRowExpressionAtom(MySqlParser.NestedRowExpressionAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mathExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expressionAtom}.
	 * @param ctx the parse tree
	 */
	void enterMathExpressionAtom(MySqlParser.MathExpressionAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mathExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expressionAtom}.
	 * @param ctx the parse tree
	 */
	void exitMathExpressionAtom(MySqlParser.MathExpressionAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code existsExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expressionAtom}.
	 * @param ctx the parse tree
	 */
	void enterExistsExpressionAtom(MySqlParser.ExistsExpressionAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code existsExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expressionAtom}.
	 * @param ctx the parse tree
	 */
	void exitExistsExpressionAtom(MySqlParser.ExistsExpressionAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intervalExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expressionAtom}.
	 * @param ctx the parse tree
	 */
	void enterIntervalExpressionAtom(MySqlParser.IntervalExpressionAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intervalExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expressionAtom}.
	 * @param ctx the parse tree
	 */
	void exitIntervalExpressionAtom(MySqlParser.IntervalExpressionAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code jsonExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expressionAtom}.
	 * @param ctx the parse tree
	 */
	void enterJsonExpressionAtom(MySqlParser.JsonExpressionAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code jsonExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expressionAtom}.
	 * @param ctx the parse tree
	 */
	void exitJsonExpressionAtom(MySqlParser.JsonExpressionAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subqueryExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expressionAtom}.
	 * @param ctx the parse tree
	 */
	void enterSubqueryExpressionAtom(MySqlParser.SubqueryExpressionAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subqueryExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expressionAtom}.
	 * @param ctx the parse tree
	 */
	void exitSubqueryExpressionAtom(MySqlParser.SubqueryExpressionAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code constantExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expressionAtom}.
	 * @param ctx the parse tree
	 */
	void enterConstantExpressionAtom(MySqlParser.ConstantExpressionAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code constantExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expressionAtom}.
	 * @param ctx the parse tree
	 */
	void exitConstantExpressionAtom(MySqlParser.ConstantExpressionAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionCallExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expressionAtom}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallExpressionAtom(MySqlParser.FunctionCallExpressionAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionCallExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expressionAtom}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallExpressionAtom(MySqlParser.FunctionCallExpressionAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expressionAtom}.
	 * @param ctx the parse tree
	 */
	void enterBinaryExpressionAtom(MySqlParser.BinaryExpressionAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expressionAtom}.
	 * @param ctx the parse tree
	 */
	void exitBinaryExpressionAtom(MySqlParser.BinaryExpressionAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fullColumnNameExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expressionAtom}.
	 * @param ctx the parse tree
	 */
	void enterFullColumnNameExpressionAtom(MySqlParser.FullColumnNameExpressionAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fullColumnNameExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expressionAtom}.
	 * @param ctx the parse tree
	 */
	void exitFullColumnNameExpressionAtom(MySqlParser.FullColumnNameExpressionAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bitExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expressionAtom}.
	 * @param ctx the parse tree
	 */
	void enterBitExpressionAtom(MySqlParser.BitExpressionAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bitExpressionAtom}
	 * labeled alternative in {@link MySqlParser#expressionAtom}.
	 * @param ctx the parse tree
	 */
	void exitBitExpressionAtom(MySqlParser.BitExpressionAtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#unaryOperator}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOperator(MySqlParser.UnaryOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#unaryOperator}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOperator(MySqlParser.UnaryOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void enterComparisonOperator(MySqlParser.ComparisonOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void exitComparisonOperator(MySqlParser.ComparisonOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#logicalOperator}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOperator(MySqlParser.LogicalOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#logicalOperator}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOperator(MySqlParser.LogicalOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#bitOperator}.
	 * @param ctx the parse tree
	 */
	void enterBitOperator(MySqlParser.BitOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#bitOperator}.
	 * @param ctx the parse tree
	 */
	void exitBitOperator(MySqlParser.BitOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#mathOperator}.
	 * @param ctx the parse tree
	 */
	void enterMathOperator(MySqlParser.MathOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#mathOperator}.
	 * @param ctx the parse tree
	 */
	void exitMathOperator(MySqlParser.MathOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#jsonOperator}.
	 * @param ctx the parse tree
	 */
	void enterJsonOperator(MySqlParser.JsonOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#jsonOperator}.
	 * @param ctx the parse tree
	 */
	void exitJsonOperator(MySqlParser.JsonOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#charsetNameBase}.
	 * @param ctx the parse tree
	 */
	void enterCharsetNameBase(MySqlParser.CharsetNameBaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#charsetNameBase}.
	 * @param ctx the parse tree
	 */
	void exitCharsetNameBase(MySqlParser.CharsetNameBaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#transactionLevelBase}.
	 * @param ctx the parse tree
	 */
	void enterTransactionLevelBase(MySqlParser.TransactionLevelBaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#transactionLevelBase}.
	 * @param ctx the parse tree
	 */
	void exitTransactionLevelBase(MySqlParser.TransactionLevelBaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#privilegesBase}.
	 * @param ctx the parse tree
	 */
	void enterPrivilegesBase(MySqlParser.PrivilegesBaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#privilegesBase}.
	 * @param ctx the parse tree
	 */
	void exitPrivilegesBase(MySqlParser.PrivilegesBaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#intervalTypeBase}.
	 * @param ctx the parse tree
	 */
	void enterIntervalTypeBase(MySqlParser.IntervalTypeBaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#intervalTypeBase}.
	 * @param ctx the parse tree
	 */
	void exitIntervalTypeBase(MySqlParser.IntervalTypeBaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#dataTypeBase}.
	 * @param ctx the parse tree
	 */
	void enterDataTypeBase(MySqlParser.DataTypeBaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#dataTypeBase}.
	 * @param ctx the parse tree
	 */
	void exitDataTypeBase(MySqlParser.DataTypeBaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#keywordsCanBeId}.
	 * @param ctx the parse tree
	 */
	void enterKeywordsCanBeId(MySqlParser.KeywordsCanBeIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#keywordsCanBeId}.
	 * @param ctx the parse tree
	 */
	void exitKeywordsCanBeId(MySqlParser.KeywordsCanBeIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#functionNameBase}.
	 * @param ctx the parse tree
	 */
	void enterFunctionNameBase(MySqlParser.FunctionNameBaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#functionNameBase}.
	 * @param ctx the parse tree
	 */
	void exitFunctionNameBase(MySqlParser.FunctionNameBaseContext ctx);
}