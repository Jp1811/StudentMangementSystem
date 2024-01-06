package com.example.studentsys;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.*;

public class dashboardController implements Initializable {

    @FXML
    private Button course_btn_add;

    @FXML
    private Button course_btn_clear;

    @FXML
    private Button course_btn_delete;

    @FXML
    private Button course_btn_update;

    @FXML
    private TableColumn<courseData, String> course_col_course;

    @FXML
    private TableColumn<courseData, String> course_col_degree;

    @FXML
    private TableColumn<courseData, String> course_col_description;

    @FXML
    private AnchorPane course_dashboard;

    @FXML
    private TextField course_fill_course;

    @FXML
    private TextField course_fill_degree;

    @FXML
    private TextField course_fill_description;

    @FXML
    private TableView<courseData> course_table;

    @FXML
    private TextField gradeSearch;

    @FXML
    private Button grade_btn_clear;

    @FXML
    private Button grade_btn_update;

    @FXML
    private TableColumn<studentData, String> grade_col_course;

    @FXML
    private TableColumn<studentData, String> grade_col_final;

    @FXML
    private TableColumn<studentData, String> grade_col_firstSemester;

    @FXML
    private TableColumn<studentData, String> grade_col_secondSemester;

    @FXML
    private TableColumn<studentData, String> grade_col_student;

    @FXML
    private TableColumn<studentData, String> grade_col_year;

    @FXML
    private AnchorPane grade_dashboard;

    @FXML
    private TextField grade_fill_firstSem;

    @FXML
    private TextField grade_fill_id;

    @FXML
    private TextField grade_fill_secondtSem;

    @FXML
    private FontAwesomeIconView grade_icon_search;

    @FXML
    private TableView<studentData> grade_table;

    @FXML
    private Label grade_textId;

    @FXML
    private Label grade_text_course;

    @FXML
    private Label grade_text_firstSem;

    @FXML
    private Label grade_text_infoCourse;

    @FXML
    private Label grade_text_infoYear;

    @FXML
    private Label grade_text_secondSem;

    @FXML
    private Label grade_text_year;

    @FXML
    private BarChart<?, ?> home_bar_female;

    @FXML
    private BarChart<?, ?> home_bar_male;

    @FXML
    private BarChart<?, ?> home_bar_students;

    @FXML
    private AnchorPane home_card_female;

    @FXML
    private AnchorPane home_card_male;

    @FXML
    private AnchorPane home_card_students;

    @FXML
    private AnchorPane home_dashboard;

    @FXML
    private FontAwesomeIconView home_icon_female;

    @FXML
    private FontAwesomeIconView home_icon_male;

    @FXML
    private FontAwesomeIconView home_icon_students;

    @FXML
    private Label home_score_female;

    @FXML
    private Label home_score_male;

    @FXML
    private Label home_score_students;

    @FXML
    private Label home_text_female;

    @FXML
    private Label home_text_male;

    @FXML
    private Label home_text_students;

    @FXML
    private AnchorPane main_dashboard;

    @FXML
    private Button nav_btn_courses;

    @FXML
    private Button nav_btn_grades;

    @FXML
    private Button nav_btn_home;

    @FXML
    private Button nav_btn_signOut;

    @FXML
    private Button nav_btn_students;

    @FXML
    private AnchorPane nav_dashboard;

    @FXML
    private FontAwesomeIconView nav_icon;

    @FXML
    private FontAwesomeIconView nav_icon_courses;

    @FXML
    private FontAwesomeIconView nav_icon_grades;

    @FXML
    private FontAwesomeIconView nav_icon_home;

    @FXML
    private FontAwesomeIconView nav_icon_signOut;

    @FXML
    private FontAwesomeIconView nav_icon_students;

    @FXML
    private Label nav_text_signOut;

    @FXML
    private Label nav_text_user;

    @FXML
    private Label nav_text_welcome;

    @FXML
    private FontAwesomeIconView student_icon_search;

    @FXML
    private ComboBox<?> students_box_course;

    @FXML
    private DatePicker students_box_date;

    @FXML
    private ComboBox<?> students_box_sex;

    @FXML
    private ComboBox<?> students_box_status;

    @FXML
    private ComboBox<?> students_box_year;

    @FXML
    private Button students_btn_clear;

    @FXML
    private Button students_btn_delete;

    @FXML
    private Button students_btn_add;

    @FXML
    private Button students_btn_update;

    @FXML
    private TableColumn<studentData, String> students_col_course;

    @FXML
    private TableColumn<studentData, String> students_col_date;

    @FXML
    private TableColumn<studentData, String> students_col_firstName;

    @FXML
    private TableColumn<studentData, String> students_col_id;

    @FXML
    private TableColumn<studentData, String> students_col_lastName;

    @FXML
    private TableColumn<studentData, String> students_col_sex;

    @FXML
    private TableColumn<studentData, String> students_col_status;

    @FXML
    private TableColumn<studentData, String> students_col_year;

    @FXML
    private AnchorPane students_dashboard;

    @FXML
    private TextField students_fill_firstName;

    @FXML
    private TextField students_fill_id;

    @FXML
    private TextField students_fill_lastName;

    @FXML
    private TextField students_search;

    @FXML
    private TableView<studentData> students_table;

    @FXML
    private AnchorPane top_dashboard;

    @FXML
    private Button top_exit;

    @FXML
    private FontAwesomeIconView top_icon;

    @FXML
    private Button top_minimize;

    @FXML
    private Label top_text_program;

    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;

    public void homeTotalStudents(){
        String sql = "SELECT COUNT(id) FROM student";

        connect= database.connectDb();
        int countEnrolled =0;

        try {
            prepare=connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()){

                countEnrolled = result.getInt("COUNT(id)");

            }
            home_score_students.setText(String.valueOf(countEnrolled));
        }catch (Exception e){e.printStackTrace();}

    }

    public void homeDisplayMale(){

        String sql = "SELECT COUNT(id) FROM student WHERE sex = 'Male' and status ='Enrolled'";

        connect=database.connectDb();

        try {

            int countMale =0;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()){

                countMale = result.getInt("COUNT(id)");
            }
            home_score_male.setText(String.valueOf(countMale));

        }catch (Exception e){e.printStackTrace();}

    }

    public void homeDisplayFemale(){

        String sql = "SELECT COUNT(id) FROM student WHERE sex = 'Female' and status ='Enrolled'";

        connect=database.connectDb();

        try {

            int countFemale =0;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()){

                countFemale = result.getInt("COUNT(id)");
            }
            home_score_female.setText(String.valueOf(countFemale));

        }catch (Exception e){e.printStackTrace();}
    }

    public void homeTotalChart(){
        home_bar_students.getData().clear();

        String sql = "SELECT date, COUNT(id) FROM student WHERE status ='Enrolled' GROUP BY date ORDER BY TIMESTAMP(date) ASC LIMIT 5";

        connect = database.connectDb();

        try {

            XYChart.Series chart = new XYChart.Series();


            prepare = connect.prepareStatement(sql);
            result=prepare.executeQuery();

            while (result.next()){

                chart.getData().add(new XYChart.Data(result.getString(1), result.getInt(2)));


            }

            home_bar_students.getData().add(chart);

        }catch (Exception e){e.printStackTrace();}
    }

    public void homeMaleChart(){
        home_bar_male.getData().clear();

        String sql = "SELECT date, COUNT(id) FROM student WHERE sex = 'Male' and status ='Enrolled' GROUP BY date ORDER BY TIMESTAMP(date) ASC LIMIT 5";


        connect = database.connectDb();

        try {

            XYChart.Series chart = new XYChart.Series();


            prepare = connect.prepareStatement(sql);
            result=prepare.executeQuery();

            while (result.next()){

                chart.getData().add(new XYChart.Data(result.getString(1), result.getInt(2)));


            }

            home_bar_male.getData().add(chart);

        }catch (Exception e){e.printStackTrace();}

    }

    public void homeFemaleChart(){
        home_bar_female.getData().clear();

        String sql = "SELECT date, COUNT(id) FROM student WHERE sex = 'Female' and status ='Enrolled' GROUP BY date ORDER BY TIMESTAMP(date) ASC LIMIT 5";

        connect = database.connectDb();

        try {

            XYChart.Series chart = new XYChart.Series();


            prepare = connect.prepareStatement(sql);
            result=prepare.executeQuery();

            while (result.next()){

                chart.getData().add(new XYChart.Data(result.getString(1), result.getInt(2)));


            }

            home_bar_female.getData().add(chart);

        }catch (Exception e){e.printStackTrace();}

    }


    public ObservableList<studentData> studentGradesListData(){
        ObservableList<studentData> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM student_grade";

        connect = database.connectDb();
        try {
            studentData studentD;

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()){

                studentD = new studentData(result.getInt("studentId")
                        , result.getString("year")
                        , result.getString("course")
                        , result.getDouble("first_sem")
                        , result.getDouble("second_sem")
                        , result.getDouble("final"));

                listData.add(studentD);

            }


        }catch (Exception e){e.printStackTrace();}
        return listData;
    }

    private ObservableList<studentData> studentGradesList;
    public void studentGradesShowListData(){

        studentGradesList = studentGradesListData();

        grade_col_student.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        grade_col_year.setCellValueFactory(new PropertyValueFactory<>("year"));
        grade_col_course.setCellValueFactory(new PropertyValueFactory<>("course"));
        grade_col_firstSemester.setCellValueFactory(new PropertyValueFactory<>("firstSem"));
        grade_col_secondSemester.setCellValueFactory(new PropertyValueFactory<>("secondSem"));
        grade_col_final.setCellValueFactory(new PropertyValueFactory<>("finals"));

        grade_table.setItems(studentGradesList);

    }


    public ObservableList<studentData> addStudentListData(){
        ObservableList<studentData> listStudents = FXCollections.observableArrayList();

        String sql = "SELECT * FROM student";

        connect = database.connectDb();

        try {

            studentData studentD;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()){
                studentD = new studentData(result.getInt("studentId")
                        , result.getString("year")
                        , result.getString("course")
                        , result.getString("firstName")
                        , result.getString("lastName")
                        , result.getString("sex")
                        , result.getDate("birth")
                        , result.getString("status"));

                listStudents.add(studentD);

            }

        }catch (Exception e){e.printStackTrace();}
        return listStudents;
    }

    public void studentGradeSelected(){

        studentData studentD = grade_table.getSelectionModel().getSelectedItem();
        int num = grade_table.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1){
            return;
        }

        grade_fill_id.setText(String.valueOf(studentD.getStudentId()));
        grade_text_infoYear.setText(String.valueOf(studentD.getYear()));
        grade_text_infoCourse.setText(String.valueOf(studentD.getCourse()));
        grade_fill_firstSem.setText(String.valueOf(studentD.getFirstSem()));
        grade_fill_secondtSem.setText(String.valueOf(studentD.getSecondSem()));

    }

    public void studentGradesSearch(){

        FilteredList<studentData> filter = new FilteredList<>(studentGradesList, e-> true);

        gradeSearch.textProperty().addListener((Observable, oldValue, newValue)->{

            filter.setPredicate(predicateStudentData->{

                if (newValue.isEmpty() || newValue == null){

                    return true;
                }

                String searchKey = newValue.toLowerCase();

                if (predicateStudentData.getStudentId().toString().contains(searchKey)){
                    return true;

                } else if (predicateStudentData.getYear().toLowerCase().contains(searchKey)) {
                    return true;
                }else if (predicateStudentData.getCourse().toLowerCase().contains(searchKey)){

                    return true;
                }
                return false;
            });

        });

        SortedList<studentData> sortList = new SortedList<>(filter);
        sortList.comparatorProperty().bind(grade_table.comparatorProperty());
        grade_table.setItems(sortList);

    }

    public void studentGradesUpdate(){

        double finalCheck1= 0;
        double finalCheck2= 0;
        String checkData = "SELECT * FROM student_grade WHERE studentId = '"+grade_fill_id.getText()+"'";

        connect = database.connectDb();
        double finalResult = 0;
        try {
            prepare = connect.prepareStatement(checkData);
            result = prepare.executeQuery();

            if (result.next()){
                finalCheck1 = result.getDouble("first_sem");
                finalCheck2 = result.getDouble("second_sem");

            }
            if (finalCheck1 ==0 || finalCheck2 ==0) {
                finalResult = 0;
            } else {
                finalResult = (Double.parseDouble(grade_fill_firstSem.getText())
                        +Double.parseDouble(grade_fill_secondtSem.getText())/2);

            }

            String updateData = "UPDATE student_grade SET "
                        +"year = '"+grade_text_infoYear.getText()
                        +"', course = '"+grade_text_infoCourse.getText()
                        +"', first_sem = '"+grade_fill_firstSem.getText()
                        +"', second_sem = '"+grade_fill_secondtSem.getText()
                        +"', final = '"+finalResult+"' WHERE studentId = '"+grade_fill_id.getText()+"'";

            Alert alert;

            if (grade_fill_id.getText().isEmpty()
                    || grade_text_infoYear.getText().isEmpty()
                    || grade_text_infoCourse.getText().isEmpty()){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            }else{

                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to Update Student"+grade_fill_id.getText()+" ?");
                Optional<ButtonType>option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)){
                    statement = connect.createStatement();
                    statement.executeUpdate(updateData);

                    studentGradesShowListData();
                    studentGradesClear();

                }else return;

            }

        }catch (Exception e){e.printStackTrace();}


    }

    public void studentGradesClear(){
        grade_fill_id.setText("");
        grade_text_infoYear.setText("");
        grade_text_infoCourse.setText("");
        grade_fill_firstSem.setText("");
        grade_fill_secondtSem.setText("");


    }

    private ObservableList<studentData> addStudentsListD;
    public void addStudentsAdd(){

        String insertData = "INSERT INTO student (studentId,year,course,firstName,lastName,sex,birth,status,date) VALUES(?,?,?,?,?,?,?,?,?)";

        connect = database.connectDb();

        try {

            Alert alert;

            if (students_fill_id.getText().isEmpty()
                    || students_box_year.getSelectionModel().getSelectedItem() == null
                    || students_box_course.getSelectionModel().getSelectedItem() == null
                    || students_fill_firstName.getText().isEmpty()
                    || students_fill_lastName.getText().isEmpty()
                    || students_box_sex.getSelectionModel().getSelectedItem() == null
                    || students_box_date.getValue() == null
                    || students_box_status.getSelectionModel().getSelectedItem() == null){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            }else{

                String checkDat = "SELECT studentId FROM student WHERE studentId = '"
                        +students_fill_id.getText()+"'";

                statement = connect.createStatement();
                result = statement.executeQuery(checkDat);

                if (result.next()){
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("ID" + students_fill_id.getText() + " was already exist!");
                    alert.showAndWait();
                }else {
                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, students_fill_id.getText());
                    prepare.setString(2, (String)students_box_year.getSelectionModel().getSelectedItem());
                    prepare.setString(3, (String)students_box_course.getSelectionModel().getSelectedItem());
                    prepare.setString(4, students_fill_firstName.getText());
                    prepare.setString(5, students_fill_lastName.getText());
                    prepare.setString(6, (String) students_box_sex.getSelectionModel().getSelectedItem());
                    prepare.setString(7, String.valueOf(students_box_date.getValue()));
                    prepare.setString(8, (String) students_box_status.getSelectionModel().getSelectedItem());

                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    prepare.setString(9,String.valueOf(sqlDate));

                    prepare.executeUpdate();


                    String insertStudentGrade = "INSERT INTO student_grade "
                            +"(studentId,year,course,first_sem,second_sem,final) "
                            +"VALUES(?,?,?,?,?,?)";

                    prepare = connect.prepareStatement(insertStudentGrade);
                    prepare.setString(1, students_fill_id.getText());
                    prepare.setString(2, (String)students_box_year.getSelectionModel().getSelectedItem());
                    prepare.setString(3, (String)students_box_course.getSelectionModel().getSelectedItem());
                    prepare.setString(4, "0");
                    prepare.setString(5, "0");
                    prepare.setString(6, "0");

                    prepare.executeUpdate();


                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Informative Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();

                    addStudentsShowListData();
                    addStudentsClear();


                }

            }

        }catch (Exception e){e.printStackTrace();}

    }

    public void addStudentsClear(){

        students_fill_id.setText("");
        students_fill_firstName.setText("");
        students_fill_lastName.setText("");
        students_box_course.getSelectionModel().clearSelection();
        students_box_status.getSelectionModel().clearSelection();
        students_box_sex.getSelectionModel().clearSelection();
        students_box_year.getSelectionModel().clearSelection();
        students_box_date.setValue(null);

    }

    public void addStudentsDelete(){
        String deleteData = "DELETE FROM student WHERE studentId = '"
                +students_fill_id.getText()+"'";

        connect = database.connectDb();
        try{
            Alert alert;
            if (students_fill_id.getText().isEmpty()
                    ||students_fill_firstName.getText().isEmpty()
                    ||students_fill_lastName.getText().isEmpty()
                    ||students_box_date.getValue() == null){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            }else{
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to Delete Student"+students_fill_id.getText()+" ?");
                Optional<ButtonType> option = alert.showAndWait();
                if (option.get().equals(ButtonType.OK)){

                    statement = connect.createStatement();
                    statement.executeUpdate(deleteData);

                    String checkData = "SELECT studentId FROM student_grade "
                            + "WHERE studentId = '"+students_fill_id.getText()+"'";

                    prepare = connect.prepareStatement(checkData);
                    result = prepare.executeQuery();

                    if (result.next()){

                        String deleteGrade = "DELETE FROM student_grade WHERE "
                                + "studentId = '"+students_fill_id.getText()+"'";
                        statement = connect.createStatement();
                        statement.executeUpdate(deleteGrade);

                    }





                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();

                    addStudentsShowListData();
                    addStudentsClear();

                }else return;
            }
        }catch (Exception e){e.printStackTrace();}
    }

    public void studentsSearch(){

        FilteredList<studentData> filter = new FilteredList<>(addStudentsListD, e-> true);

        students_search.textProperty().addListener((Observable, oldValue, newValue)->{

            filter.setPredicate(predicateStudentData->{

                if(newValue == null || newValue.isEmpty()){
                    return true;
                }
                String searchKey = newValue.toLowerCase();

                if (predicateStudentData.getStudentId().toString().contains(searchKey)){
                    return true;
                } else if (predicateStudentData.getYear().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateStudentData.getCourse().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateStudentData.getFirstName().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateStudentData.getLastName().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateStudentData.getStatus().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateStudentData.getSex().toLowerCase().contains(searchKey)){
                    return true;
                }else
                    return false;
            });
        });

        SortedList<studentData> sortList = new SortedList<>(filter);
        sortList.comparatorProperty().bind(students_table.comparatorProperty());
        students_table.setItems(sortList);
    }

    public void addStudentsUpdate(){
        String updateData = "UPDATE student SET "
                +"year = '"+students_box_year.getSelectionModel().getSelectedItem()
                +"', course = '"+students_box_course.getSelectionModel().getSelectedItem()
                +"', firstName = '"+students_fill_firstName.getText()
                +"', lastName = '"+students_fill_lastName.getText()
                +"', sex = '"+students_box_sex.getSelectionModel().getSelectedItem()
                +"', birth = '"+students_box_date.getValue()
                +"', status = '"+students_box_status.getSelectionModel().getSelectedItem()
                +"' WHERE studentId = '"+students_fill_id.getText()+"'";

        connect = database.connectDb();

        try {

            Alert alert;
            if (students_fill_id.getText().isEmpty()
                    ||students_box_year.getSelectionModel().getSelectedItem() == null
                    ||students_box_course.getSelectionModel().getSelectedItem() == null
                    ||students_fill_firstName.getText().isEmpty()
                    ||students_fill_lastName.getText().isEmpty()
                    ||students_box_sex.getSelectionModel().getSelectedItem() == null
                    ||students_box_date.getValue() == null
                    ||students_box_status.getSelectionModel().getSelectedItem() == null){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            }else{

                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to Update Student" + students_fill_id.getText() + " ?");
                Optional<ButtonType> option =alert.showAndWait();

                if (option.get().equals(ButtonType.OK)){
                    statement = connect.createStatement();
                    statement.executeUpdate(updateData);

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();

                    addStudentsShowListData();
                    addStudentsClear();
                }



            }

        }catch (Exception e){e.printStackTrace();}
    }

    private String[] yearList = {"First Year", "Second Year", "Third Year", "Fourth Year"};
    public void addStudentsYearList(){

        List<String> yearL = new ArrayList<>();

        for (String data: yearList){
            yearL.add(data);

        }

        ObservableList ObList = FXCollections.observableArrayList(yearL);
        students_box_year.setItems(ObList);

    }

    public void addStudentsCourseList(){
        String listCourse = "SELECT * FROM course";

        connect = database.connectDb();
        try {
            ObservableList listC = FXCollections.observableArrayList();

            prepare = connect.prepareStatement(listCourse);
            result = prepare.executeQuery();

            while (result.next()){
                listC.add(result.getString("course"));

            }
            students_box_course.setItems(listC);
        }catch (Exception e){e.printStackTrace();}
    }

    private String[] sexList = {"Male", "Female"};
    public void addStudentsSexList(){
        List<String> sexL = new ArrayList<>();

        for(String data: sexList){
            sexL.add(data);

        }

        ObservableList ObList = FXCollections.observableArrayList(sexL);
        students_box_sex.setItems(ObList);

    }
    private String[] statusList = {"Enrolled", "Not Enrolled", "Inactive"};
    public void addStudentsStatusList(){
        List<String> statusL = new ArrayList<>();

        for(String data: statusList){
            statusL.add(data);

        }

        ObservableList ObList = FXCollections.observableArrayList(statusL);
        students_box_status.setItems(ObList);
    }

    public void addStudentsShowListData(){
        addStudentsListD = addStudentListData();

        students_col_id.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        students_col_year.setCellValueFactory(new PropertyValueFactory<>("year"));
        students_col_course.setCellValueFactory(new PropertyValueFactory<>("course"));
        students_col_firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        students_col_lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        students_col_sex.setCellValueFactory(new PropertyValueFactory<>("sex"));
        students_col_date.setCellValueFactory(new PropertyValueFactory<>("birth"));
        students_col_status.setCellValueFactory(new PropertyValueFactory<>("status"));

        students_table.setItems(addStudentsListD);
    }

    public void addStudentsSelect(){
        studentData studentD = students_table.getSelectionModel().getSelectedItem();
        int num = students_table.getSelectionModel().getSelectedIndex();

        if ((num-1)<-1 ) {return;}

        students_fill_id.setText(String.valueOf(studentD.getStudentId()));
        students_fill_firstName.setText(studentD.getFirstName());
        students_fill_lastName.setText(studentD.getLastName());
        students_box_date.setValue(LocalDate.parse(String.valueOf(studentD.getBirth())));


    }

    public ObservableList<courseData> availableCourseListData(){
        ObservableList<courseData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM course";

        connect = database.connectDb();

        try{
            courseData courseD;
            prepare = connect.prepareStatement(sql);
            result  = prepare.executeQuery();

            while(result.next()){
                courseD = new courseData(result.getString("course")
                        , result.getString("description")
                        , result.getString("degree"));

                listData.add(courseD);

            }
        } catch(Exception e){e.printStackTrace();}
        return listData;
    }

    private ObservableList<courseData> availableCourseList;
    public void availableCourShowListData(){
        availableCourseList = availableCourseListData();

        course_col_course.setCellValueFactory(new PropertyValueFactory<>("course"));
        course_col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        course_col_degree.setCellValueFactory(new PropertyValueFactory<>("degree"));

        course_table.setItems(availableCourseList);
    }

    public void availableCourseSelect(){

        courseData courseD = course_table.getSelectionModel().getSelectedItem();
        int num = course_table.getSelectionModel().getSelectedIndex();

        if ((num -1)<-1){
            return;
        }

        course_fill_course.setText(courseD.getCourse());
        course_fill_description.setText(courseD.getDescription());
        course_fill_degree.setText(courseD.getDegree());
    }

    public void availableCourseAdd(){

        String insertData = "INSERT INTO course (course,description,degree) VALUES(?,?,?)";

        connect = database.connectDb();

        try{
            Alert alert;

            if (course_fill_course.getText().isEmpty()
                    ||course_fill_description.getText().isEmpty() || course_fill_degree.getText().isEmpty() ){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            }else{
                String checkData = "SELECT course FROM course WHERE course = '"
                        + course_fill_course.getText()+"'";
                statement = connect.createStatement();
                result = statement.executeQuery(checkData);

                if (result.next()){
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Course: " + course_fill_course.getText() + " was already exist!");
                    alert.showAndWait();
                }else{
                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, course_fill_course.getText());
                    prepare.setString(2, course_fill_description.getText());
                    prepare.setString(3, course_fill_degree.getText());

                    prepare.executeUpdate();
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();

                    availableCourShowListData();
                    availableCourseClear();

                }


            }

        }catch(Exception e){e.printStackTrace();}

    }

    public void availableCourseDelete(){
        String deleteData = "DELETE FROM course WHERE course ='"
                +course_fill_course.getText()+"'";
        connect = database.connectDb();
        try {
            Alert alert;
            if (course_fill_course.getText().isEmpty()
                    ||course_fill_description.getText().isEmpty() || course_fill_degree.getText().isEmpty() ) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please Fill all blank fields");
                alert.showAndWait();
            }else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to Delete Course: "+ course_fill_course.getText()+" ?");
                Optional<ButtonType> option = alert.showAndWait();

                if(option.get().equals(ButtonType.OK)){
                    statement = connect.createStatement();
                    statement.executeUpdate(deleteData);

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();

                    availableCourseClear();
                    availableCourShowListData();

                }else return;
            }
        }catch (Exception e){e.printStackTrace();}
    }

    public void availableCourseClear(){
        course_fill_course.setText("");
        course_fill_description.setText("");
        course_fill_degree.setText("");
    }

    public void availableCourseUpdate(){
        String updateData = "UPDATE course SET description ='"
                +course_fill_description.getText()+"', degree = '"
                +course_fill_degree.getText()+"' WHERE course = '"
                +course_fill_course.getText()+"'";

        connect = database.connectDb();

        try{
            Alert alert;
            if (course_fill_course.getText().isEmpty()
                    ||course_fill_description.getText().isEmpty() || course_fill_degree.getText().isEmpty() ){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please Fill all blank fields");
                alert.showAndWait();
            }else{
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to Update Course: "+ course_fill_course.getText()+" ?");
                Optional<ButtonType> option = alert.showAndWait();

                if(option.get().equals(ButtonType.OK)){
                    statement = connect.createStatement();
                    statement.executeUpdate(updateData);

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();
                }else return;


            }
        }catch (Exception e){e.printStackTrace();}
    }




    public void switchForm(ActionEvent event){
        if (event.getSource()==nav_btn_home){
            home_dashboard.setVisible(true);
            students_dashboard.setVisible(false);
            course_dashboard.setVisible(false);
            grade_dashboard.setVisible(false);

            nav_btn_home.setStyle("-fx-background-color: #165dff");
            nav_btn_students.setStyle("-fx-background-color: #1a93e7");
            nav_btn_courses.setStyle("-fx-background-color: #1a93e7");
            nav_btn_grades.setStyle("-fx-background-color: #1a93e7");

            homeTotalStudents();
            homeDisplayMale();
            homeDisplayFemale();
            homeTotalChart();
            homeMaleChart();
            homeFemaleChart();
        } else if (event.getSource() == nav_btn_students) {
            students_dashboard.setVisible(true);
            home_dashboard.setVisible(false);
            course_dashboard.setVisible(false);
            grade_dashboard.setVisible(false);

            nav_btn_students.setStyle("-fx-background-color: #165dff");
            nav_btn_home.setStyle("-fx-background-color: #1a93e7");
            nav_btn_courses.setStyle("-fx-background-color: #1a93e7");
            nav_btn_grades.setStyle("-fx-background-color: #1a93e7");

            addStudentsShowListData();
            addStudentsYearList();
            addStudentsSexList();
            addStudentsStatusList();
            addStudentsCourseList();
            studentsSearch();

        } else if (event.getSource() == nav_btn_courses) {
            course_dashboard.setVisible(true);
            students_dashboard.setVisible(false);
            home_dashboard.setVisible(false);
            grade_dashboard.setVisible(false);

            nav_btn_students.setStyle("-fx-background-color: #1a93e7");
            nav_btn_home.setStyle("-fx-background-color: #1a93e7");
            nav_btn_courses.setStyle("-fx-background-color: #165dff");
            nav_btn_grades.setStyle("-fx-background-color: #1a93e7");

            availableCourShowListData();
            availableCourseSelect();

        } else if (event.getSource() == nav_btn_grades) {
            grade_dashboard.setVisible(true);
            course_dashboard.setVisible(false);
            students_dashboard.setVisible(false);
            home_dashboard.setVisible(false);

            nav_btn_students.setStyle("-fx-background-color: #1a93e7");
            nav_btn_home.setStyle("-fx-background-color: #1a93e7");
            nav_btn_courses.setStyle("-fx-background-color: #1a93e7");
            nav_btn_grades.setStyle("-fx-background-color: #165dff");

            studentGradesShowListData();
            studentGradesSearch();

        }


    }

    public void close(){
        System.exit(0);

    }

    public void minimize(){
        Stage stage = (Stage)main_dashboard.getScene().getWindow();
        stage.setIconified(true);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        homeTotalChart();
        homeMaleChart();
        homeFemaleChart();
        homeTotalStudents();
        homeDisplayMale();
        homeDisplayFemale();
        addStudentsShowListData();
        addStudentsSelect();
        addStudentsYearList();
        addStudentsSexList();
        addStudentsStatusList();
        addStudentsCourseList();
        availableCourShowListData();
        studentGradesShowListData();
        studentGradesSearch();
    }
}
