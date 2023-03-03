package com.comgen;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.comgen.dto.ManagerDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.comgen.dao.IDao;
import com.comgen.dto.FactDto;
import com.comgen.dto.RequestDto;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class WebController {

	@ Autowired
	private SqlSession sqlSession;
	
	@RequestMapping(value = "/")

	public String index(HttpServletRequest request, Model model){

		String managernm = request.getParameter("managernm");
		String factnm = request.getParameter("factnm");

		IDao dao = sqlSession.getMapper(IDao.class);

		ArrayList<RequestDto> aDtos = null;
		ArrayList<RequestDto> fDtos = dao.F_listDao();
		ArrayList<FactDto> nDtos = dao.factlistDao();
		ArrayList<ManagerDto> mDtos = dao.mlistDao();
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("managernm", managernm);
		paramMap.put("factnm", factnm);

		aDtos = dao.managerlistDao(managernm, factnm);

		model.addAttribute("request_list", aDtos);
		model.addAttribute("fact_list", fDtos);
		model.addAttribute("nfact_list", nDtos);
		model.addAttribute("manager_list", mDtos);
		return "index";

	}
	
	@RequestMapping(value = "index")
	
	public String index1(HttpServletRequest request, Model model){

		
		String managernm = request.getParameter("managernm");
		String factnm = request.getParameter("factnm");

		IDao dao = sqlSession.getMapper(IDao.class);
		
		ArrayList<RequestDto> aDtos = null;
		ArrayList<RequestDto> fDtos = dao.F_listDao();
		ArrayList<FactDto> nDtos = dao.factlistDao();
		ArrayList<ManagerDto> mDtos = dao.mlistDao();
	    Map<String, Object> paramMap = new HashMap<>();
	    paramMap.put("managernm", managernm);
	    paramMap.put("factnm", factnm);
		
		aDtos = dao.managerlistDao(managernm, factnm);
			
		model.addAttribute("request_list", aDtos);
		model.addAttribute("fact_list", fDtos);
		model.addAttribute("nfact_list", nDtos);
		model.addAttribute("manager_list", mDtos);
	return "index";


	}
	
	@RequestMapping(value="/input")
	public String input(HttpServletRequest request, Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		ArrayList<RequestDto> fDtos = dao.F_listDao();
		ArrayList<FactDto> nDtos = dao.factlistDao();
		ArrayList<ManagerDto> mDtos = dao.mlistDao();
		model.addAttribute("nfact_list", nDtos);
		model.addAttribute("fact_list", fDtos);
		model.addAttribute("manager_list", mDtos);
	return "input";
	}
	
	@RequestMapping(value ="/inputOk")
	public String b_inputOk(HttpServletRequest request, Model model) {
		
		String factnm = request.getParameter("factnm");
		String requestgr = request.getParameter("requestgr");
		String requesternm = request.getParameter("requesternm");
		String requestdate = request.getParameter("requestdate");
		String requestcomment = request.getParameter("requestcomment");
		String managernm = request.getParameter("managernm");
		String resultstat = request.getParameter("resultstat");
		String enddate = request.getParameter("enddate");
		String note = request.getParameter("note");
		
		
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    long diff = 0;
		    try {
		        Date endDate = sdf.parse(enddate);
		        Date requestDate = sdf.parse(requestdate);
		        diff = endDate.getTime() - requestDate.getTime();
		    } catch (ParseException e) {
		        e.printStackTrace();
		    }
		    long days = diff / (24 * 60 * 60 * 1000);

		 // 시간 계산
		    long hours = (diff / (60 * 60 * 1000)) % 24;
		  String processingtime = days + "day " + hours + "hours";
		
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.r_inputDao(factnm, requestgr, requesternm, requestdate, requestcomment, managernm, resultstat, enddate, processingtime, note);
			
		return "redirect:index";
	}
	
	@RequestMapping(value = "/delete")
	public String delete(HttpServletRequest request, Model model) {

		String managernm = request.getParameter("managernm");
		String factnm = request.getParameter("factnm");
		IDao dao = sqlSession.getMapper(IDao.class);
		ArrayList<RequestDto> aDtos = null;
		ArrayList<RequestDto> fDtos = dao.F_listDao();
		ArrayList<FactDto> nDtos = dao.factlistDao();
		ArrayList<ManagerDto> mDtos = dao.mlistDao();
		
	    Map<String, Object> paramMap = new HashMap<>();
	    paramMap.put("managernm", managernm);
	    paramMap.put("factnm", factnm);
		aDtos = dao.managerlistDao(managernm, factnm);
		model.addAttribute("request_list", aDtos);
		model.addAttribute("fact_list", fDtos);
		model.addAttribute("nfact_list", nDtos);
		model.addAttribute("manager_list", mDtos);
	return "delete";

	}
	
	@RequestMapping(value = "/deleteOk")
	public String deleteOk(HttpServletRequest request, Model model) {

		String requestno = request.getParameter("requestno");
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.deleteDao(requestno);
		return "redirect:index";	
		
	
	}
	
	@RequestMapping(value = "/updateOk")
	public String update(HttpServletRequest request, Model model) {

	    String factnm = request.getParameter("factnm");
	    String requestgr = request.getParameter("requestgr");
	    String requesternm = request.getParameter("requesternm");
	    String requestdate = request.getParameter("requestdate");
	    String requestcomment = request.getParameter("requestcomment");
	    String managernm = request.getParameter("managernm");
	    String resultstat = request.getParameter("resultstat");
	    String enddate = request.getParameter("enddate");
	    String note = request.getParameter("note");
	    String requestno = request.getParameter("requestno");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		long diff = 0;
		try {
			Date endDate = sdf.parse(enddate);
			Date requestDate = sdf.parse(requestdate);
			diff = endDate.getTime() - requestDate.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long days = diff / (24 * 60 * 60 * 1000);

		// 시간 계산
		long hours = (diff / (60 * 60 * 1000)) % 24;
		String processingtime = days + "day " + hours + "hours";


	    IDao dao = sqlSession.getMapper(IDao.class);
	    dao.updateDao(factnm, requestgr, requestdate, requesternm, requestcomment, managernm, resultstat, enddate, processingtime, note, requestno);

		model.addAttribute("message", "수정이 완료되었습니다.");
	    return "redirect:index";
	}
	
	
	@RequestMapping(value="/finput")
	public String finput(HttpServletRequest request, Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		ArrayList<RequestDto> fDtos = dao.F_listDao();
		model.addAttribute("fact_list", fDtos);
	return "finput";
	}
	
	
	@RequestMapping(value ="/finputOk")
	public String finputOk(HttpServletRequest request, Model model) {
		String factcd = request.getParameter("factcd");
		String factnm = request.getParameter("factnm");
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		int checkNm = dao.nmcheckDao(factnm);
		
		if(checkNm != 1) {
			dao.fact_inputDao(factnm);
			model.addAttribute("message", "사업장정보가 저장되었습니다.");
			model.addAttribute("factcd", factcd);
			model.addAttribute("factnm", factnm);
			
		} else { 
			model.addAttribute("message", "이미 존재하는 사업장 입니다.");
		}
	
	return "flist";
	}

	@RequestMapping(value ="/flist")
	public String flist(HttpServletRequest request, Model model) {

		IDao dao = sqlSession.getMapper(IDao.class);
		ArrayList<FactDto> nDtos = dao.factlistDao();
		model.addAttribute("nfact_list", nDtos);
		return "flist";
	}

	@RequestMapping(value = "/fdeleteOk")
	public String fdeleteOk(HttpServletRequest request, Model model) {

		String factcd = request.getParameter("factcd");
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.fdeleteDao(factcd);
		return "redirect:flist";
	}

	@RequestMapping(value ="/mlist")
	public String mlist(HttpServletRequest request, Model model) {

		IDao dao = sqlSession.getMapper(IDao.class);
		ArrayList<ManagerDto> mDtos = dao.mlistDao();
		model.addAttribute("manager_list", mDtos);

		String message = (String)request.getAttribute("message"); // 리다이렉트 후 전달받은 메시지 가져오기
		if(message != null) {
			model.addAttribute("message", message); // 메시지 추가
		}
		return "mlist";
	}

	@RequestMapping(value="/minput")
	public String minput(HttpServletRequest request, Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		ArrayList<ManagerDto> mDtos = dao.mlistDao();
		model.addAttribute("manager_list", mDtos);
		return "minput";
	}

	@RequestMapping(value ="/minputOk")
	public String minputOk(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		String managercd = request.getParameter("managercd");
		String managernm = request.getParameter("managernm");

		IDao dao = sqlSession.getMapper(IDao.class);

		int checknm = dao.mcheckDao(managernm);

		if(checknm != 1) {
			dao.manager_inputDao(managernm);
			redirectAttributes.addFlashAttribute("message", "담당자정보가 저장되었습니다.");
			redirectAttributes.addFlashAttribute("managercd", managercd);
			redirectAttributes.addFlashAttribute("managernm", managernm);
		} else {
			redirectAttributes.addFlashAttribute("message", "이미 존재하는 담당자명 입니다.");
		}
		return "redirect:/mlist";
	}

	@RequestMapping(value = "/mdeleteOk")
	public String mdeleteOk(HttpServletRequest request, Model model) {

		String managercd = request.getParameter("managercd");
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.mdeleteDao(managercd);
		return "redirect:mlist";
	}
}
