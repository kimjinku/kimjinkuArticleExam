import java.util.ArrayList;
import java.util.Scanner;


public class ArticleExam {



   static ArrayList<Article> articles = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int lastId = 1;


        while (true) {
            System.out.print("명령어 : ");
            String command = scan.nextLine();
            if (command.equals("exit")) {

                break;

            } else if (command.equals("add")) {

                System.out.print("제목 : ");
                String title = scan.nextLine();
                System.out.print("내용 : ");
                String content = scan.nextLine();
                Article article = new Article(lastId, title, content);
                articles.add(article);
                System.out.println("게시물이 등록되었습니다");

                lastId++;


            } else if (command.equals("list")) {
                for (int i = 0; i < articles.size(); i++) {

                    Article article = articles.get(i);

                    System.out.printf("번호 : %d\n", article.getId());

                    System.out.printf("제목 : %s\n", article.getTitle());
                    System.out.println("==================================");


                }

            } else if (command.equals("update")) {
                System.out.print("수정할 게시물 번호 : ");
                int targetId = scan.nextInt();

                scan.nextLine();

                Article article = findByID(targetId);
                if(article==null){
                    System.out.println("존재하지 않는 게시물 번호입니다");

                }else{
                    System.out.print("새로운 제목 : ");
                    String newTitle = scan.nextLine();
                    System.out.print("새로운 내용 : ");
                    String newContent = scan.nextLine();
                    article.setTitle(newTitle);
                    article.setContent(newContent);

                    System.out.printf("%d번 게시물이 수정되었습니다\n",targetId);


                }


            }else if(command.equals("delete")){
                System.out.print("삭제할 게시물 번호 : ");
                int targetId = scan.nextInt();

                scan.nextLine();

                Article article = findByID(targetId);
                if(article==null){
                    System.out.println("존재하지 않는 게시물 번호입니다");

                }else{
                    articles.remove(article);
                    System.out.printf("%d번 게시물이 삭제되었습니다.\n",targetId);
                }


            }else if (command.equals("detail")){
                System.out.print("상세보기할 게시물 번호를 입력해주세요 : ");
                int targetId = scan.nextInt();

                scan.nextLine();

                Article article = findByID(targetId);
                if(article==null){
                    System.out.println("존재하지 않는 게시물 번호입니다");

                }else{
                    System.out.printf("번호 : %d\n", article.getId());

                    System.out.printf("제목 : %s\n", article.getTitle());

                    System.out.printf("내용 : %s\n", article.getContent());

                }


            }
        }

    }public static Article findByID(int id){
        Article target = null;
        for(int i=0; i<articles.size();i++){
            Article article = articles.get(i);
            if(id== article.getId()){
                target= article;
            }

        }return target;
    }
}

class Article {
    int id;
    String title;
    String content;

    public Article(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Article(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
