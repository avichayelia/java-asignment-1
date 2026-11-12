public class File 
{
 private String fileName;
 private String fileType;
	
 public String getFileType()
 {
	 return fileType;
	 
 }
 
 public void setFileType(String type)
 {
	 if(type.equals(""))
			 throw new IllegalArgumentException("File type cannot be empty");
	 
	 this.fileType=type;
 }
 
 public String getFileName()
 {
	 return fileName;
	 
 }
 
 public void setFileName(String name)
 {
	 if(name.equals(""))
			 throw new IllegalArgumentException("File name cannot be empty");
	 
	 this.fileName=name;
 }
 
 public File(String name , String type)
 {
	 if(name.equals(""))
  		 throw new IllegalArgumentException("File's name cannot be empty");
	 
       if(type.equals(""))
		 throw new IllegalArgumentException("File's type cannot be empty");
       
       this.fileName=name;
       this.fileType=type;
	 
	 
 }
 @Override public String toString()
 {
	 return "File's name:"+this.fileName +", File's type:"+ this.fileType ;
	 
 }
 
}
