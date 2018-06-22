import java.io.*;

public class Main {
    private static  String fileRead;
    private static  String fileWrite;
    private static StringBuffer stringBuffer;
    private static int linhaComeco;
    public static void main(String[] args){
        stringBuffer = new StringBuffer();
        linhaComeco = 0;
//        fileRead = "/home/gustavo.castro/Desktop/teste.txt";
        fileRead = "/home/gustavo.castro/Desktop/imageTeste.txt";
        fileWrite = "/home/gustavo.castro/Desktop/imageTesteJPG.txt";
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileRead)));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(fileWrite)));

            linhaComeco = 0;
            while (bufferedReader.ready()){
                String valor  = bufferedReader.readLine();
                if(!valor.equals("") || !valor.equals(" ")){

//                    valor = valor.replace("0x","");
//                    valor = valor.replace(",","");
//                    bufferedWriter.write(valor.toLowerCase());
//                    bufferedWriter.newLine();
                    linhaComeco++;
                    if(linhaComeco == 5){
                        valor = valor.substring(13,valor.length());
                        System.out.println("Linha "+linhaComeco+" : "+valor);
                        bufferedWriter.write(valor.replace(" ","").toUpperCase());
//                        System.out.println(valor);
                    }

                    if(valor.equals("") || valor.equals(" ")){
                        linhaComeco = 0;
                    }else if (linhaComeco > 5){
//                    else if(linhaComeco > 5 && linhaComeco <= 111){
                        valor = valor.substring(7,valor.length());
                        System.out.println("Linha "+linhaComeco+" : "+valor);
                        bufferedWriter.write(valor.replace(" ","").toUpperCase());
//                        if (linhaComeco == 111){
//                            linhaComeco = 0;
//                        }
                    }
                }
                if (valor.equals("") || valor.equals(" ")){
                    linhaComeco = 0;
                    System.out.println("Espaco");
                }
            }
            bufferedWriter.flush();
            bufferedWriter.close();
            bufferedReader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
