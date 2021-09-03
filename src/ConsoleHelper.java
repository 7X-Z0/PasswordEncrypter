public class ConsoleHelper {
    private String lastLine = "";

    public void print(String line){
        if (lastLine.length() > line.length()) {
            String temp = "";
            for (int i = 0; i < lastLine.length(); i++) {
                temp += " ";
            }
            if (temp.length() > 1){
                System.out.print("\r" + temp);
        }
            System.out.print("\r" + temp);
                lastLine = line;
            }
        }
    private byte anim;
    public void animate(String line){
        switch (anim) {
            case 1 -> System.out.print("[ \b ]");
            case 2 -> System.out.print("[ | ]");
            case 3 -> System.out.print(" / ");
            default -> {
                anim = 0;
                System.out.print(" - ");
                anim++;
            }
        }
    }
}

