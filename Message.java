import java.util.Date;
import java.util.ArrayList;

public abstract class Message 
{

	protected String sender;
	protected String content;
	protected Date sendDate;
	
	
	public String getSender()
	 {
		 return sender;
		 
	 }
	 
	 public void setSender(String sender)
	 {
		 if(sender.equals(""))
				 throw new IllegalArgumentException("Message's sender cannot be empty");
		 
		 this.sender=sender;
	 }
	 
	 public String getContent()
	 {
		 return this.content;
		 
	 }
	 
	 public void setContent(String content)
	 {
		 if(content.equals(""))
				 throw new IllegalArgumentException("Message's content cannot be empty");
		 
		 this.content=content;
	 }
	
	 public Date getDate()
	 {
		 return sendDate;
		 
	 }
	
	 public void setDate(Date date)
	 {
		 
		 this.sendDate=date;         // לפי דרישת התרגיל התאריך יכול להיות ריק
	 }
	
	
	 public Message(String sender , String content , Date date)
	 {
		 if(sender.equals(""))
	  		 throw new IllegalArgumentException("Message's sender cannot be empty");
		 
	       if(content.equals(""))
			 throw new IllegalArgumentException("Message's content cannot be empty");
	       
	       this.sender=sender;
	       this.content=content;
	       this.sendDate=date;	 
	 }
	 
	 public Message(String sender, String content)
	    {
	        if(sender.equals(""))
	            throw new IllegalArgumentException("Message's sender cannot be empty");
			 
	        if(content.equals(""))
	            throw new IllegalArgumentException("Message's content cannot be empty");
		       
	        this.sender = sender;
	        this.content = content;
	        this.sendDate = new Date();
	        
	    }
	 
	 @Override public String toString()
	 {
		 return "Message's sender:"+ sender +"\nmessage's content:"+ content +"\nsent on" + sendDate;
		 
	 }
	 
	 public boolean find(ArrayList<String> words)
	 {
		 for(int i=0; i< words.size() ;i++)
		 {
			if(this.content.contains(words.get(i))) 
			   return true;
			 
		 }
		 
		 return false;
	 }
	 
	 public boolean isSentBy(String name)
	    {
	        if (this.sender.equals(name))
	        	return true;
	        else
	        return false;
	    }
	 
	 public abstract String generatePreview();
	
}


