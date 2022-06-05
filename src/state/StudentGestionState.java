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
		  JPanel view = new JPanel();
		  JScrollPane pane = new JScrollPane(view, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		  for(Student student : students) {
			  view.add(new JLabel(student.toString()));
		  }
		  pane.add(view);
		  this.add(view);
	}

}
