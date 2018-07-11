package com.gx.utils;

import javax.servlet.http.Cookie;

public class CookieUtils {
	public static Cookie getCookie(Cookie[] allCookie, String cookieName) {
		if (cookieName == null)
			return null;
		if (allCookie != null) {
			for (Cookie cookie : allCookie) {
				if (cookieName.equals(cookie.getName()))
					return cookie;
			}

		}
		return null;
	}

}
