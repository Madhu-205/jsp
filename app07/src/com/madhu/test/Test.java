package com.madhu.test;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.ParseException;
import org.springframework.expression.ParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import com.madhu.bean.CalCulatorBean;

public class Test {

	public static void main(String[] args)throws Exception {
	ExpressionParser parse = new SpelExpressionParser();
	Expression exper=parse.parseExpression("10+10");
	System.out.println(exper.getValue());
	
	exper=parse.parseExpression("abc'+'def");
	System.out.println(exper.getValue());
	
	   

	}

}
