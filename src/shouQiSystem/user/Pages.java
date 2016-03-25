package shouQiSystem.user;

import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

public class Pages {
	    ResultSet CountTopicrs=null;
        ResultSet Pagirs=null;
	    public int intCountTopic=0;
	    public int intPageSize;
	    public int intPageCount;
	    public int intPage=1;
	    public String nowPage;
	    public String HttpFile;
	    UserInfo db;
	    
	    public Pages(){
	    	intPageSize=2;
	    	db=new UserInfo();
	    }
	    
	    public void querySql(ResultSet CountTopicrs,ResultSet Pagirs,HttpServletRequest request)throws Exception{
	    	HttpFile=request.getRequestURI();
	    	nowPage=request.getParameter("pages");
	    	if(nowPage==null){
	    		intPage=1;
	    	}else{
	    		intPage=Integer.parseInt(nowPage);
	    		if(intPage<1)
	    			intPage=1;
	    	}
	    	
	    	//CountTopicrs=db.queryICcardDataSum(name, carNum);
	    	if(CountTopicrs.next()){
	    		intCountTopic=CountTopicrs.getInt(1);
	    	}
	    	intPageCount=(intCountTopic+intPageSize-1)/intPageSize;
	    	if(intPage>intPageCount){
	    		intPage=intPageCount;
	    	}
	    	CountTopicrs.close();
	    	//db.close_all();
	    	//Pagirs=db.queryICcardData(name, carNum);
	    	//return Pagirs;
	    }
	    public int getCountTopic(){
	    	return intCountTopic;
	    }
	    public int getPageCount(){
	    	return intPageCount;
	    }
	    public int getIntPage(){
	    	return intPage;
	    }
	    public String PageFooter(){
	    	String str="";
	    	int next,prev;
	    	prev=intPage-1;
	    	next=intPage+1;
	    	System.out.println();
	    	str+="<font color=red>��ѯ��"+getCountTopic()+"����¼</font>"+" <font color=red> ��"+getPageCount()+"ҳ</font>";
	    	str+="<font color=red>��"+getIntPage()+"ҳ</font>";
	    	if(intPage>1)
	    		str+="<font color=red><a href=" + HttpFile + "?pages=1"+">��ҳ</a></font>";
	    	else 
	    		str+="<font color=red>��ҳ";
	    	if(intPage>1)
	    		str +="<font color=red><a href=" + HttpFile + "?pages="+prev+">��һҳ</a></font>";
	    	else
	    		str +="<font color=red>��һҳ</font>";
	    	if(intPage<intPageCount)
	    		str +="<font color=red><a href=" + HttpFile + "?pages="+next+">��һҳ</a></font>";
	    	else
	    		str +="<font color=red>��һҳ</font>";
	    	if(intPageCount>1&&intPage !=intPageCount)
	    		str +="<font color=red><a href=" + HttpFile + "?pages="+intPageCount+">βҳ</a></font>";
	    	else
	    		str +="<font color=red>βҳ</font>";
	    	return str;
	    }
	    public void close_all()throws Exception{
	    	db.close_all();
	    }
}
