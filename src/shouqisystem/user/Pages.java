package shouqisystem.user;

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
	    	str+="<font color=red>查询到"+getCountTopic()+"条记录</font>"+" <font color=red> 共"+getPageCount()+"页</font>";
	    	str+="<font color=red>第"+getIntPage()+"页</font>";
	    	if(intPage>1)
	    		str+="<font color=red><a href=" + HttpFile + "?pages=1"+">首页</a></font>";
	    	else 
	    		str+="<font color=red>首页";
	    	if(intPage>1)
	    		str +="<font color=red><a href=" + HttpFile + "?pages="+prev+">上一页</a></font>";
	    	else
	    		str +="<font color=red>上一页</font>";
	    	if(intPage<intPageCount)
	    		str +="<font color=red><a href=" + HttpFile + "?pages="+next+">下一页</a></font>";
	    	else
	    		str +="<font color=red>下一页</font>";
	    	if(intPageCount>1&&intPage !=intPageCount)
	    		str +="<font color=red><a href=" + HttpFile + "?pages="+intPageCount+">尾页</a></font>";
	    	else
	    		str +="<font color=red>尾页</font>";
	    	return str;
	    }
	    public void close_all()throws Exception{
	    	db.close_all();
	    }
}
