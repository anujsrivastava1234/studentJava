import java.util.Scanner;

public class Sms2 {
  private int rollno;
  String name;
  static String School_name;
  String address;
  String course;

  static {
    School_name = "Witshaper";

  }

  Sms2() {
  }

  Sms2 Add(int l) {
    Sms2 o = new Sms2();
    if (l > 1000) {
      System.out.println(" over flow");
    } else {
      try {
        System.out.println("--------------------------");
        Scanner s = new Scanner(System.in);
        System.out.println("Enter name : ");
        o.name = s.next();
        System.out.println("Enter Address : ");
        o.address = s.next();
        System.out.println("Enter Course : ");
        o.course = s.next();
        System.out.println("Enter rollno : ");
        o.rollno = s.nextInt();
      } catch (Exception e) {
        System.out.println(e);
        e.getMessage();
      }
    }
    return (o);

  }

  void search(int rollno, int l, Sms2 s[]) {
    for (int i = 0; i < l; i++) {
      if (s[i].rollno == rollno) {
        s[i].display(s[i]);
      }
    }
  }

  boolean delete(int rollno, Sms2 o[], int l) {
    boolean t = false;
    for (int i = 0; i < l; i++) {
      if (rollno == o[i].rollno) {
        for (int j = i; j < l - 1; j++) {
          o[j] = o[j - 1];
        }
        t = true;
        return (t);
      }
    }
    return (t);
  }

  boolean update(int rollno, Sms2[] obj, int l) {
    boolean t = false;

    for (int i = 0; i < l; i++) {
      if (rollno == obj[i].rollno) {
        try {
          System.out.println("--------------------------");
          Scanner s = new Scanner(System.in);
          System.out.println("Enter name : ");
          obj[i].name = s.next();
          System.out.println("Enter Address : ");
          obj[i].address = s.next();
          System.out.println("Enter course : ");
          obj[i].course = s.next();

          t = true;
          return (t);

        } catch (Exception e) {
          System.out.println(e);
          e.getMessage();
        }
      }

    }

    return (t);
  }

  private void display(Sms2 s) {
    System.out.println("----------------------");
    System.out.println("name : " + s.name);
    System.out.println("Address : " + s.address);
    System.out.println("course : " + s.course);
    System.out.println("rollno : " + s.rollno);
  }

  void show(int l, Sms2 s[]) {
    for (int i = 0; i < l; i++) {
      System.out.println("---------------------");
      System.out.println("Name : " + s[i].name);
      System.out.println("Address : " + s[i].address);
      System.out.println("Course : " + s[i].course);
      System.out.println("rollno : " + s[i].rollno);
    }

  }

  public static void main(String[] args) {
    Sms2 obj[] = new Sms2[1000];
    Scanner s = new Scanner(System.in);
    boolean f = true;
    int choice;
    int l = 0;
    int r;
    Sms2 o = new Sms2();

    do {
      try {
        System.out.println("#### Welcome ####");
        System.out.println("Enter your choice ");
        System.out.println("1).....Add");
        System.out.println("1).....Delete");
        System.out.println("1).....Search");
        System.out.println("1).....Update");
        System.out.println("1).....Dispaly");
        choice = s.nextInt();
        try {
          switch (choice) {
            case 1:
              obj[l] = o.Add(l);

              l++;
              break;
            case 2:
              System.out.println("enter rollno for deletion ");
              r = s.nextInt();
              boolean b = o.delete(r, obj, l);
              if (b = true) {
                l--;
                System.out.println("Successfully deleted");
              } else {
                System.out.println("rollnop not found");
              }
              break;
            case 3:
              System.out.println("Enter rollno to search student ");
              r = s.nextInt();
              o.search(r, l, obj);
              break;
            case 4:
              System.out.println("Enter rollno for update");
              r = s.nextInt();
              boolean c = o.update(r, obj, l);
              if (c = true) {
                System.out.println("Successfully updated");

              } else {
                System.out.println("rollno not found");
              }
              break;
            case 5:
              o.show(l, obj);
            default:
              System.out.println("Enter rigth choice");

          }
        } catch (Exception m) {
          System.out.println(m);
        }
      } catch (Exception e) {
        System.out.println(e);
      }
      System.out.println("Want to do more...true/false");
      f = s.nextBoolean();
    } while (f);
  }
}
