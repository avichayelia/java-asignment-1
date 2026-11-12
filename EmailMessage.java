import java.util.Date;
import java.util.ArrayList;
import java.io.File;

public class EmailMessage extends Message implements IDigital
{
	private String subject;
	private ArrayList<File> attachments;
	
	public void setSub(String sub)
	{
		if (sub.equals(""))
			throw new IllegalArgumentException("subject can`t be empty");
		subject = sub;
	}
	public String getSub()
	{
		return subject;
	}
	public void setAttachment(ArrayList<File> attachments)
	{
		this.attachments = attachments;
	}
	public ArrayList<File> getAttachment()
	{
		return this.attachments;
	}
	public EmailMessage(String sender, String content, Date sendDate, String subject, ArrayList<File> attachments)
	{
		super(sender, content, sendDate);
		setSub(subject);
		setAttachment(attachments);
	}
	public EmailMessage(String sender, String content, String subject)
	{
		this(sender, content, null, subject, new ArrayList<File>());
	}
	@Override 
	public String toString()
	{
		return super.toString() + "\nsubject: " + subject + "\nattacment file: " + attachments;
	}
	@Override
	public void printCommunicationMethod() 
	{
		System.out.println("Sent via Email Server");
	}
	
	@Override
	public String generatePreview() 
	{
		return "[Email] Subject: " + subject + " | From: " + sender;
	}
	public void addAttachment(File file)
	{
		this.attachments.add(file);
	}
	
	public void removeAttachment(File file) throws AttachmentException
	{
		if (!this.attachments.contains(file))
			throw new AttachmentException("File doesn`t exist!!!");
		while(this.attachments.contains(file))
			this.attachments.remove(file);
	}
	
	
}
