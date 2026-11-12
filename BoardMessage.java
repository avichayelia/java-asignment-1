import java.util.Date;

public class BoardMessage extends Message 
{
	
    private PriorityType priority;
	
    public PriorityType getPriority()
	 {
		 return priority;
		 
	 }
	
	 public void setPriority(PriorityType priority)
	 {
		 
		 this.priority=priority;      
	 }
	
	 public BoardMessage(String sender , String content , Date date, PriorityType priority)
	 {
		 super(sender, content, date);
	     this.priority=priority;
	 }
	 
	 public BoardMessage(String sender , String content)
	 {
		 super(sender, content);
	     this.priority=PriorityType.REGULAR;
	 }
	 
	 @Override public String toString()
	 {
		 return "BoardMessage's content: "+ this.content +", sent by: "+ this.sender + ", on: "+ this.sendDate + ", message priority: "+ this.priority ;
		 
	 }
	 
	 public boolean isUrgent()            //מתודה שמחזירה האם ההודעה דחופה
	 {
		 if(this.priority==PriorityType.URGENT)
			 return true;
		 else
			 return false;
		 
     }
	 
	 public String generatePreview()
	 {
		 return "[board] "+this.sender+": "+this.content.substring(0,14)+"...";
		 
      }
	
}