import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class Main 
{

	public static void main(String[] args) throws InvalidPhoneNumberException 
	{
		ArrayList<Message> messages = new ArrayList<Message>();
		ArrayList<File> emailFile1 = new ArrayList<File>();
		emailFile1.add(new File("exercise1.java", "java"));
	
		messages.add(new BoardMessage("Orel", "Avichay, Please get back to me this is urgent", new Date(), PriorityType.URGENT));
		messages.add(new BoardMessage("Avichay", "Orel, stop messing around we need to finish the task"));

		messages.add(new ChatMessage("Avichay", "Orel, call me on Discord so we can do the task", new Date(), "0502224565"));
		messages.add(new ChatMessage("Orel", "Avichay i will call you in a few minutes", "0552556743"));

		messages.add(new EmailMessage("Avichay", "Orel this is the final file of the task in JAVA", new Date(), "task 1", emailFile1));
		messages.add(new EmailMessage("Orel", "Avichay, the code is great you can upload to GitHub", "finish task 1"));
		
		Scanner scanner = new Scanner(System.in);
		int option = -1;
		while(option != 0)
		{
			System.out.println("\n--- Choose option 0-6---\n0 - to exit! \n1- to add a message! \n2- to delete a message!"
					+ "\n3- to print all the messages!\n4- to see the amount of the messages contains a specipic word!"
					+ "\n5- to print only email messages!\n6- to filter the messages by a sender name!");
			option = Integer.parseInt(scanner.nextLine());
			switch(option)
			{
			case 0:
				System.out.println("exiting system......");
				break;
			case 1:
				System.out.println("please enter your name: ");
				String name = scanner.nextLine();
				System.out.println("please enter a message: ");
				String m = scanner.nextLine();
				System.out.println("choose message type: \n1-board \n2-chat\n3-email");
				int mType = Integer.parseInt(scanner.nextLine());
				switch(mType)
				{
				case 1:
					messages.add(new BoardMessage(name, m, new Date(), PriorityType.REGULAR));
					break;
				case 2:
					System.out.println("enter phone number: ");
					String num = scanner.nextLine();
					messages.add(new ChatMessage(name, m, new Date(), num));
					break;
				case 3:
					System.out.println("enter subject: ");
					String sub = scanner.nextLine();
					messages.add(new EmailMessage(name, m, sub));
					break;
				default:
					System.out.println("Invalid message type selected!!");
					break;
				}
				break;
				
			case 2:
				if (messages.isEmpty())
					System.out.println("there is no messages to delete");
				else
				{
					System.out.println("---please enter message index to delete ---");
					for (int i = 0; i < messages.size(); i++)
					{
						System.out.println((i + 1) + ". " + messages.get(i).generatePreview());
					}
					System.out.print("Enter the number of the message to remove (1-" + messages.size() + "): ");
			        int choice = Integer.parseInt(scanner.nextLine());
			        int indexToDelete = choice - 1;
			        
					if (indexToDelete >= 0 && indexToDelete < messages.size())
					{
						messages.remove(indexToDelete);
						System.out.println("The message has been deleted!");
					}
					else
						System.out.println("Invalid message index, No message was deleted!");
				}
				break;
			case 3:
				for(int k = 0; k < messages.size(); k++)
				{
					System.out.println(messages.get(k));
				}
				break;

			case 4:
				int counter = 0;
				System.out.println("please enter a key word to search: ");
				String keyword = scanner.nextLine();
				for (int j = 0; j < messages.size(); j++)
				{
					String currentContent = messages.get(j).getContent();
					if(currentContent.contains(keyword))
					{
						counter++;
					}
				}
				System.out.println("found: " + counter + " messages with the word: " + keyword);
				break;
			case 5:
				for(int i = 0; i < messages.size(); i++)
				{
					if(messages.get(i) instanceof EmailMessage)
					{
						System.out.println(messages.get(i));
					}
				}
				break;
			case 6:
				System.out.println("please enter a sender name to filter: ");
				String senderN = scanner.nextLine();
				boolean found = false;
				for(int i = 0; i < messages.size(); i++)
				{
					if(messages.get(i).getSender().equalsIgnoreCase(senderN))
					{
						System.out.println(messages.get(i));
						found = true;
					}
				}
				if (found == false)
					System.out.println("there are no messages from: " + senderN);
				break;
		}
			
			
			
		}
	}

}





