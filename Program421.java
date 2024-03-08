// Customised Database Management System


class Program421
{
    public static void main(String Arg[])
    {
        DBMS obj = new DBMS();

        obj.InsertIntoTable("Amit","Pune",89);
        obj.InsertIntoTable("Pooja","Mumbai",95);
        obj.InsertIntoTable("Gauri","Pune",90);
        obj.InsertIntoTable("Amit","Pune",95);
        obj.InsertIntoTable("Rahul","Satara",80);
        obj.InsertIntoTable("Neha","Pune",78);
        obj.InsertIntoTable("Amit","Pune",99);
        

        obj.SelectStarFrom();
        obj.UpdateMarks(1, 100);
        obj.SelectStarFrom();
        // obj.SelectStarFromWhereCity("pune");
        // obj.SelectStarFromWhereName("Amit");
        // obj.SelectSum();
        // obj.SelectAvg();
        // obj.SelectMax();
        // obj.SelectMin();    
        // obj.SelectStarFromWhereMarksGreater(79);
        // obj.SelectStarFromWhereMarksSmaller(99);
        // obj.UpdateCity(3, "Mumbai");
        // obj.UpdateName(3, "Gaurix");
        // obj.deleteFromWhereRno(7);
    }
}


class node
{
    private static int Counter = 1;

    public int Rno;
    public String Name;
    public String City;
    public int Marks;

    public node next;

    public node(String B, String C, int D)
    {
        Rno = Counter;
        Counter++;

        Name = B;
        City = C;
        Marks = D;
        next = null;
    }
}

class DBMS
{
    private node first;

    public DBMS()
    {
        first = null;
        System.out.println("DBMS initailised succesfully...");
        System.out.println("Student Table gets created succesfully...");
    }

    // InsertLast
    // insert into table student values(1,'Amit','Pune',89);
    public void InsertIntoTable(String Name, String City, int Marks)
    {
        node newn = new node(Name,City,Marks);

        if(first == null)
        {
            first = newn;
        }
        else
        {
            node temp = first;
            while(temp.next != null)
            {
                temp = temp.next;
            }

            temp.next = newn;
        }
        System.out.println("One record gets inserted succesfully...");
    }

    // Display
    // select * from student
    public void SelectStarFrom()
    {
        System.out.println("Data from the student table is : ");

        node temp = first;

        System.out.println("--------------------------------------------------------------");
        while(temp != null)
        {
            System.out.println(temp.Rno+"\t"+temp.Name+"\t"+temp.City+"\t"+temp.Marks);
            temp = temp.next;
        }
        System.out.println("--------------------------------------------------------------");
    }


    //select * from student where city = '______';
    public void SelectStarFromWhereCity(String Str)
    {
        System.out.println("Data from the student table where City is : "+Str);

        node temp = first;

        System.out.println("--------------------------------------------------------------");
        while(temp != null)
        {
            if(Str.equalsIgnoreCase(temp.City))
            {
            System.out.println(temp.Rno+"\t"+temp.Name+"\t"+temp.City+"\t"+temp.Marks);
            }
            temp = temp.next;
        }
        System.out.println("--------------------------------------------------------------");
    }

    //select * from student where Name = '______';
    public void SelectStarFromWhereName(String Str)
    {
        System.out.println("Data from the student table where Name is : "+Str);

        node temp = first;

        System.out.println("--------------------------------------------------------------");
        while(temp != null)
        {
            if(Str.equalsIgnoreCase(temp.Name))
            {
            System.out.println(temp.Rno+"\t"+temp.Name+"\t"+temp.City+"\t"+temp.Marks);
            }
            temp = temp.next;
        }
        System.out.println("--------------------------------------------------------------");
    }

    //select * from student where Marks Greater than = '______';
    public void SelectStarFromWhereMarksGreater(float MarksX)
    {
        System.out.println("Data from the student table where Marks is Greater than : "+MarksX);

        node temp = first;

        System.out.println("--------------------------------------------------------------");

        while(temp != null)
        {
            if(MarksX < temp.Marks)
            {
            System.out.println(temp.Rno+"\t"+temp.Name+"\t"+temp.City+"\t"+temp.Marks);
            }
            temp = temp.next;
        }
        System.out.println("--------------------------------------------------------------");
    }

    //select * from student where Marks Greater than = '______';
    public void SelectStarFromWhereMarksSmaller(float MarksX)
    {
        System.out.println("Data from the student table where Marks is Smaller than : "+MarksX);

        node temp = first;

        System.out.println("--------------------------------------------------------------");

        while(temp != null)
        {
            if(MarksX > temp.Marks)
            {
            System.out.println(temp.Rno+"\t"+temp.Name+"\t"+temp.City+"\t"+temp.Marks);
            }
            temp = temp.next;
        }
        System.out.println("--------------------------------------------------------------");
    }



    //select Count(Marks) from student;

    public void SelectCount()
    {
        node temp = first;
        int iCnt = 0;

        while(temp != null)
        {
            temp = temp.next;
            iCnt++;
        }
        System.out.println("--------------------------------------------------------------");
        System.out.println("Number of records in table : "+iCnt);
        System.out.println("--------------------------------------------------------------");
    }

    public void SelectSum()
    {
        node temp = first;
        int iSum = 0;

        while(temp != null)
        {
            iSum = iSum + temp.Marks;
            temp = temp.next;
        }
        System.out.println("--------------------------------------------------------------");
        System.out.println("Summation of marks is : "+iSum);
        System.out.println("--------------------------------------------------------------");
    }

    public void SelectAvg()
    {
        node temp = first;
        int iSum = 0;
        int iCnt = 0;

        while(temp != null)
        {
            iSum = iSum + temp.Marks;
            temp = temp.next;
            iCnt++;
        }
        System.out.println("Summation of marks is : "+(float)((float)iSum/(float)iCnt));
    }

    public void SelectMax()
    {
        node temp = first;
        int MaxMarks = 0;

        if(temp != null)
        {
            MaxMarks = temp.Marks;
        }

        while(temp != null)
        {
            if(temp.Marks > MaxMarks )
            {
                MaxMarks = temp.Marks;
            }
            temp = temp.next;
        }
        System.out.println("Maximum marks from student table is : "+MaxMarks);
    }

    public void SelectMin()
    {
        node temp = first;
        int MinMarks = 0;

        if(temp != null)
        {
            MinMarks = temp.Marks;
        }

        while(temp != null)
        {
            if(temp.Marks < MinMarks )
            {
                MinMarks = temp.Marks;
            }
            temp = temp.next;
        }
        System.out.println("Minimum marks from student table is : "+MinMarks);
    }

    //update student set City = "------" where Rno = "-----";

    public void UpdateCity(int RollNo,String Str)
    {
        node temp = first;

        while(temp != null)
        {
            if(temp.Rno == RollNo)
            {
                temp.City = Str;
                break;
            }
            temp = temp.next;
        }
        System.out.println("--------------------------------------------------------------");
        System.out.println("Record gets updated Sucessfully...");
        System.out.println("--------------------------------------------------------------");

    }

    //update student set Name = "------" where Rno = "-----";

    public void UpdateName(int RollNo,String Str)
    {
        node temp = first;

        while(temp != null)
        {
            if(temp.Rno == RollNo)
            {
                temp.Name = Str;
                break;
            }
            temp = temp.next;
        }
        System.out.println("--------------------------------------------------------------");
        System.out.println("Record gets updated Sucessfully...");
        System.out.println("--------------------------------------------------------------");

    }

    public void UpdateMarks(int RollNo,int Mark)
    {
        node temp = first;

        while(temp != null)
        {
            if(temp.Rno == RollNo)
            {
                temp.Marks = Mark;
                break;
            }
            temp = temp.next;
        }
        System.out.println("--------------------------------------------------------------");
        System.out.println("Record gets updated Sucessfully...");
        System.out.println("--------------------------------------------------------------");

    }

    //:delete from student where Rno = _____;
    public void deleteFromWhereRno(int No)
    {
        node temp = first;
        if(temp == null) //if LL is empty
        {
            return;
        }
        //if first node is targeted node
        if(temp.Rno == No)
        {
            first = first.next;
            return;
        }

        while(temp.next != null)
        {
            if(temp.next.Rno == No)
            {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }    

    }
    
}

/*
 
SUPPORTED QUERIES:-

1.: insert into student values('Amit','Pune',78);
2.: select * from student;
3.: select * from student where City = 'Pune';
4.: select * from student where Name = 'XYZ';
5.: select * from student where Marks Greater than = "----";
6.:5.: select * from student where Marks smaller than = "----";

// Aggregate functions....SUM,COUNT,MIN,MAX,Avg

6.: select Count(Marks) from Student;
7.: select Sum(Marks) from student;
8.: select Avg(Marks) from student;
9.: select Max(Marks) from student;
10.:select Min(Marks) from student;
11.:update student set City = "------" where Rno = "-----";
12.:delete from student where Rno = _____;
 */