import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.*;
public class StudentGrade extends JFrame{
    public JTextField namefield,gradefield;
    public JLabel avg,max,min,name,grade;
    public JTextArea outputarea;
    public ArrayList<Double> grades = new ArrayList<>();
    public StudentGrade() {
        setTitle("Student Grade");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        name=new JLabel("Name");
        add(name);
        namefield=new JTextField(10);
        add(namefield);
        grade=new JLabel("Grade");
        add(grade);
        gradefield = new JTextField(5);
        add(gradefield);
        JButton addbutton = new JButton("Add");
        add(addbutton);
        outputarea =new JTextArea(10,30);
        outputarea.setEditable(false);
        add(new JScrollPane(outputarea));
        addbutton.addActionListener(e ->addGrade());
 }
 void addGrade(){
    String Name = namefield.getText();
    String gradetext = gradefield.getText();
    if(Name.isEmpty() || gradetext.isEmpty()){
        outputarea.setText("Please enter both name and grade. ");
    }
    try {
        double Grade = Double.parseDouble(gradetext);
        if(Grade<0 || Grade>100){
            throw new NumberFormatException();
        }
        grades.add(Grade);
        showsummary(Name,Grade);
        namefield.setText(" ");
        gradefield.setText(" ");
    } catch ( NumberFormatException e) {
        outputarea.setText("Please enter a valid grade(0-100)");
    }
 }
 void showsummary(String name,double grade){
    double total =0;
    double highest= grades.get(0);
    double lowest = grades.get(0);
    for(double g:grades){
        total+=g;
        if(g>highest){
            highest=g;
        }
        if(g<lowest){
            lowest=g;
        }
    }
    double average = total/grades.size();
    outputarea.setText("Added:"+name+"-"+grade+"\n");
    outputarea.append("Total Students:"+grades.size()+"\n");
    outputarea.append(String.format("Average:%2f\n",average));
    outputarea.append("Highest :"+highest+"\n");
    outputarea.append("Lowest :"+lowest+"\n");

}
 public static void main(String[] args) {
     new StudentGrade().setVisible(true);
 }
}

