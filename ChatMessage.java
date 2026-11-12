import java.util.Date;

public class ChatMessage extends Message implements IDigital
{
	private String recipientPhone;
	private boolean isRead;
	
	public void setRecipientPhone(String recipientPhone) throws InvalidPhoneNumberException
	{
		if (recipientPhone == null || recipientPhone.equals("") || recipientPhone.length() != 10)
			throw new InvalidPhoneNumberException("Invalid Israeli mobile phone number format!");
		this.recipientPhone = recipientPhone;
	}
	public String getRecipientPhone()
	{
		return this.recipientPhone;
	}
	public boolean isRead()
	{
		return isRead;
	}
	public void setRead(boolean read)
	{
		isRead = read;
	}
	public ChatMessage(String sender, String content, Date sendDate, String recipientPhone) throws InvalidPhoneNumberException
	{
		super(sender, content, sendDate);
		setRecipientPhone(recipientPhone);
		this.isRead = false;
	}
	public ChatMessage(String sender, String content, String recipientPhone) throws InvalidPhoneNumberException
	{
		this(sender, content, null, recipientPhone);
	}
	
	
	
	@Override
	public void printCommunicationMethod() 
	{
		System.out.println("Sent via Chat/Cellular Server");
	}
	
	@Override
	public String generatePreview() 
	{
		return "[Chat] To: " + recipientPhone + " | " + content;
	}
	@Override
	public String toString()
	{
		return super.toString() + "\nRecipient Phone: " + recipientPhone + "\nIs Read: " + isRead;
	}
}







