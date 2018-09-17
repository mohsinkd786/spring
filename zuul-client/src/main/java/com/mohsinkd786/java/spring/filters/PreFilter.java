package com.mohsinkd786.java.spring.filters;

import com.netflix.zuul.ZuulFilter;

public class PreFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {

		return false;
	}

	@Override
	public Object run() {
		System.out.println("Hello this is my first zuul filter");
		return null;
	}

	@Override
	public String filterType() {
		return null;
	}

	@Override
	public int filterOrder() {
		return 0;
	}
}
