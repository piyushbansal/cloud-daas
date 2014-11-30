package service;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
// JAX-RS supports an automatic mapping from JAXB annotated class to XML and JSON
// Isn't that cool?
public class QueryApi {
  private TodoObject[] todoobj;
  private String[] data;
public TodoObject[] getTodoobj() {
	return todoobj;
}
public void setTodoobj(TodoObject[] todoobj) {
	this.todoobj = todoobj;
}
public String[] getData() {
	return data;
}
public void setData(String[] data) {
	this.data = data;
}
  
  
} 
class TodoObject
{
	String label;
	String type;
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}

