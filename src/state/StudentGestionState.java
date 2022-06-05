package state;

import java.util.ArrayList;
import controlLayer.StudentCtr;
import model.Student;
import utils.Handler;
import javax.swing.*;

public class StudentGestionState extends State {

	private static final long serialVersionUID = 1L;

	public StudentGestionState(Handler handler) {
		  super(handler);
		  ArrayList<Student> students = StudentCtr.getInstance().getStudents();
		    JScrollPane pane = new JScrollPane();
		  JPanel view = new JPanel();
		  for(Student student : students) {
		    view.add(new JLabel(student.toString()));
		  }
		  pane.add(view);
		this.add(view);
	}

}
