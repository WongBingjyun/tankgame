package pratice;

class Book{
    String name;
    String author;
    int sales;
    public Book(){
        this.name = "书名";
        this.author = "作者";
        this.sales = 0;
    }
    public Book(String name, String author, int sales){
        this.name = name;
        this.author = author;
        this.sales = sales;
    }
    public void setBook(String name, String author, int sales){
        this.name = name;
        this.author = author;
        this.sales = sales;
    }
    public void printBook(){
        System.out.println("书名：" + name + "\n" + "作者：" + author + "\n" + "销售量：" + sales + "\n");
    }
}

public class TestBook {
    public static void main(String[] args){
        Book book = new Book();
        Book book1 = new Book("红楼梦", "曹雪芹", 1000);
        Book book2 = new Book();
        book2.setBook("西游记", "吴承恩", 2000);
        book.printBook();
        book1.printBook();
        book2.printBook();
    }
}
