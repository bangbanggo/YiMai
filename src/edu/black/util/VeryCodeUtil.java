package edu.black.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class VeryCodeUtil {
    public boolean veryCode(HttpServletRequest request, String gotCode){
        HttpSession session  = request.getSession();
        String reslCode = (String)session.getAttribute("rand");
        if (reslCode.equals(reslCode)){
            return true;
        }else {
            return false;
        }
    }
}
