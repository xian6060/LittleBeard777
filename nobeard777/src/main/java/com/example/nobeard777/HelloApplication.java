package com.example.nobeard777;

import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.util.Random;

import static java.lang.Integer.parseInt;

public class HelloApplication extends Application {
    Image ldr_beard1 = new Image("https://i.imgur.com/jcKnYkG.png");
    Image ldr_beard2 = new Image("https://i.imgur.com/pmVa5hY.png");
    Image ldr_beard3 = new Image("https://i.imgur.com/8dIAl23.png");
    Image ldr_beard = ldr_beard1;

    int size = 50;
    //the prize
    public int lastprize=0;
    public int prize;
    //the horse
    public int winhorse;
    public int bethorse;

    public static void main() throws IOException {
        launch();
    }
    public void start(Stage stage){
        stage.setTitle("刮鬍子!娛樂城777");
        //boom 777///
        Image boom_img = new Image("https://i.imgur.com/wVVmce0.png");
        ImageView boom_imgv = new ImageView(boom_img);
        boom_imgv.setY(-20);
        boom_imgv.setX(10);
        boom_imgv.setFitHeight(200);
        boom_imgv.setPreserveRatio(true);
        //boom 777///
        Image bub_img = new Image("https://i.imgur.com/umLRWNY.png");
        ImageView bub_imgv = new ImageView(bub_img);
        bub_imgv.setY(0);
        bub_imgv.setX(450);
        bub_imgv.setFitHeight(150);
        bub_imgv.setPreserveRatio(true);
        bub_imgv.setRotate(30);
        //button start//
        Button btn_start = new Button();
        btn_start.setStyle("-fx-background-color: Transparent");
        Image img_start = new Image("https://i.imgur.com/VIZpxLQ.png");
        ImageView imgv_start = new ImageView(img_start);
        imgv_start.setFitHeight(80);
        imgv_start.setPreserveRatio(true);
        btn_start.setGraphic(imgv_start);
        btn_start.setLayoutX(100); btn_start.setLayoutY(250);
        btn_start.setOnAction((e)->{

            this.game_selection(stage);

        });
        //button information//
        Button btn_info = new Button();
        btn_info.setStyle("-fx-background-color: Transparent");
        Image img_info = new Image("https://i.imgur.com/mKnZdYm.png");
        ImageView imgv_info = new ImageView(img_info);
        imgv_info.setFitHeight(80);
        imgv_info.setPreserveRatio(true);
        btn_info.setGraphic(imgv_info);
        btn_info.setLayoutX(430); btn_info.setLayoutY(250);
        btn_info.setOnAction((e)->{
            this.info(stage);
        });
        //background //
        Image image = new Image("https://i.imgur.com/FAywHwM.png");
        BackgroundSize size = new BackgroundSize(BackgroundSize.AUTO,
                BackgroundSize.AUTO,
                false,
                false,
                true,
                false);

        Background background = new Background(new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                size));

        Pane root = new Pane();
        root.setBackground(background);
        root.getChildren().addAll(btn_start,btn_info,boom_imgv,bub_imgv);
        stage.setScene(new Scene(root, 640, 400));
        stage.show();
    }
    public void info(Stage stage) {
        stage.setTitle("梁北北有話說");
        //info icon//
        Image info_img = new Image("https://i.imgur.com/YvSThu3.png");
        ImageView info_imgv = new ImageView(info_img);
        info_imgv.setFitHeight(80);
        info_imgv.setPreserveRatio(true);
        info_imgv.setX(80);
        info_imgv.setY(60);
        //conversation //
        Image con_img = new Image("https://i.imgur.com/Nc4zaC7.png");
        ImageView con_imgv = new ImageView(con_img);
        con_imgv.setPreserveRatio(false);
        con_imgv.setFitHeight(400);
        con_imgv.setFitWidth(640);
        //information text//
        TextFlow tf = new TextFlow();
        Text info_text = new Text("歡迎來到刮鬍子!娛樂城777\n" );
        Text txt2 = new Text("這裡玩家提供多種不同的遊戲\n");
        Text txt3 = new Text("玩家一開始擁有固定長度的鬍子\n");
        Text txt4 = new Text("只要遊戲成功\n");
        Text txt5 = new Text("即可依倍率增加鬍子長短\n" );
        Text txt6 = new Text("但請注意一旦遊戲失敗\n" );
        Text txt7 = new Text("您將會面臨輸到沒鬍子的窘境\n");
        Text txt8 = new Text("很划算吧!要不要賭阿~~~");

        Font f = Font.font("Noto Serif TC", FontWeight.BOLD, 20);
        info_text.setFont(f);
        txt2.setFont(f);
        txt3.setFont(f);
        txt4.setFont(f);
        txt5.setFont(f);
        txt6.setFont(f);
        txt7.setFont(f);
        txt8.setFont(f);
        tf.getChildren().add(info_text);
        tf.setLayoutY(100);
        tf.setLayoutX(180);
        // timeline //
        Timeline tl = new Timeline(new KeyFrame(Duration.millis(1200), new EventHandler<ActionEvent>() {
            int i=1;
            @Override
            public void handle(ActionEvent actionEvent) {
                if(i==1){
                    i+=1;
                    tf.getChildren().add(txt2);
                } else if (i==2) {
                    i+=1;
                    tf.getChildren().add(txt3);
                } else if (i==3) {
                    i+=1;
                    tf.getChildren().add(txt4);
                }else if (i==4) {
                    i+=1;
                    tf.getChildren().add(txt5);
                }else if (i==5) {
                    i+=1;
                    tf.getChildren().add(txt6);
                }else if (i==6) {
                    i+=1;
                    tf.getChildren().add(txt7);
                }else if (i==7) {
                    i+=1;
                    tf.getChildren().add(txt8);
                }
            }
        }));

        tl.setCycleCount(70);
        tl.play();
        //button exit//
        Button btn_exit = new Button();
        btn_exit.setStyle("-fx-background-color: Transparent");
        Image img_exit = new Image("https://i.imgur.com/0H2fRoW.png");
        ImageView imgv_exit = new ImageView(img_exit);
        imgv_exit.setFitHeight(100);
        imgv_exit.setPreserveRatio(true);
        btn_exit.setGraphic(imgv_exit);
        btn_exit.setLayoutX(500); btn_exit.setLayoutY(290);
        btn_exit.setOnAction((e)->{
            this.start(stage);
        });

        //background //
        Image image = new Image("https://i.imgur.com/kMMDrYL.jpg");
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(false);
        imageView.setFitHeight(400);
        imageView.setFitWidth(640);
        Pane root = new Pane();
        root.getChildren().addAll(imageView,info_imgv,con_imgv,tf,btn_exit);
        stage.setScene(new Scene(root, 640, 400));
        stage.show();

    }
    public void slot_machine(Stage stage) throws IOException {
        stage.setTitle("鬍子老虎機");

        //beard pictures//
        Image img1 = new Image("https://i.imgur.com/2nnHI64.png");
        Image img2 = new Image("https://i.imgur.com/NBeX0iG.png");
        Image img3 = new Image("https://i.imgur.com/tfpATbC.png");
        Image img4 = new Image("https://i.imgur.com/VoXTzFH.png");
        ImageView img1view = new ImageView(img1);
        ImageView img2view = new ImageView(img2);
        ImageView img3view = new ImageView(img3);
        img1view.setFitWidth(92);
        img1view.setFitHeight(80);
        img2view.setFitWidth(92);
        img2view.setFitHeight(80);
        img3view.setFitWidth(92);
        img3view.setFitHeight(80);
        img1view.setX(42); img1view.setY(130);
        img2view.setX(165); img2view.setY(130);
        img3view.setX(288); img3view.setY(130);

        //  TextFlow creation start
        TextFlow tf = new TextFlow();
        Text txt_start = new Text("Start");
        txt_start.setFill(Color.WHITE);
        Font f = Font.font("Verdana", FontWeight.BOLD, 20);
        txt_start.setFont(f);
        tf.getChildren().add(txt_start);
        tf.setLayoutX(500); tf.setLayoutY(110);

        //button start//
        Button btn_start = new Button();
        btn_start.setStyle("-fx-background-color: Transparent");
        Image img_start = new Image("https://i.imgur.com/VIZpxLQ.png");
        ImageView imgv_start = new ImageView(img_start);
        imgv_start.setFitHeight(80);
        imgv_start.setPreserveRatio(true);
        btn_start.setGraphic(imgv_start);
        btn_start.setLayoutX(450); btn_start.setLayoutY(70);
        btn_start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Runtime.getRuntime().exec("beard777.exe");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Image[] img_list={img1,img2,img3,img4};
                ImageView[] imgv_list={img1view,img2view,img3view};

                //get txt file//
                File file = new File("777.txt");
                BufferedReader br = null;
                try {
                    br = new BufferedReader(new FileReader(file));
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                String string_in_txt;
                try {
                    string_in_txt=br.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                //change string into int in txt file//
                Integer[] int_in_txt={0,0,0};
                Integer j=0;
                for(int i=0;i<string_in_txt.length();i++) {
                    if (string_in_txt.charAt(i) >= '0' && string_in_txt.charAt(i) <= '9') {
                        int_in_txt[j] = string_in_txt.charAt(i) - '0';
                        j += 1;
                    }
                }
                Random rand = new Random();
                Timeline tl = new Timeline(new KeyFrame(Duration.millis(40), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        int rand_int1 = rand.nextInt(4);
                        int rand_int2 = rand.nextInt(4);
                        int rand_int3 = rand.nextInt(4);
                        img1view.setImage(img_list[rand_int1]);
                        img2view.setImage(img_list[rand_int2]);
                        img3view.setImage(img_list[rand_int3]);
                    }
                }));
                tl.setCycleCount(70);
                tl.play();
                tl.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        int rand1 = rand.nextInt(4);
                        int rand2 = rand.nextInt(4);
                        int rand3 = rand.nextInt(4);
                        int_in_txt[0] = (rand1 + int_in_txt[0]) % 4 + 1;
                        int_in_txt[1] = (rand2 + int_in_txt[1]) % 4 + 1;
                        int_in_txt[2] = (rand3 + int_in_txt[2]) % 4 + 1;
                        for(int i=0;i<int_in_txt.length;i++){
                            imgv_list[i].setImage(img_list[ (int_in_txt[i]-1) ]);
                        }System.out.println(size);
                        if(int_in_txt[0].equals(int_in_txt[1]) && int_in_txt[1].equals(int_in_txt[2])){
                            size = size + 50;
                        }
                        else {
                            size = size - 5;
                            if(size<=0){
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                jail(stage);
                            }
                        }
                    }
                });
            }
        });

        //button exit//
        Button btn_exit = new Button();
        btn_exit.setStyle("-fx-background-color: Transparent");
        Image img_exit = new Image("https://i.imgur.com/0H2fRoW.png");
        ImageView imgv_exit = new ImageView(img_exit);
        imgv_exit.setFitHeight(100);
        imgv_exit.setPreserveRatio(true);
        btn_exit.setGraphic(imgv_exit);
        btn_exit.setLayoutX(470); btn_exit.setLayoutY(180);
        btn_exit.setOnAction((e)->{
            this.game_selection(stage);
        });
        //TextFlow creation start
        TextFlow tf2 = new TextFlow();
        Text txt_exit = new Text("Exit");
        txt_exit.setFill(Color.WHITE);
        txt_exit.setFont(f);
        tf2.getChildren().add(txt_exit);
        tf2.setLayoutX(500); tf2.setLayoutY(220);
        //background //
        Image image = new Image("https://i.imgur.com/prnOGSM.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(400);
        imageView.setFitWidth(640);

        //pane//
        Pane root = new Pane();
        root.getChildren().addAll(imageView,img1view,img2view,img3view,btn_start,btn_exit);
        stage.setScene(new Scene(root, 640, 400));
        stage.show();
    }
    public void plate(Stage stage){
        Pane pane = new Pane();
        //background
        Image backgroundimg = new Image("https://i.imgur.com/GAh7EaP.png");
        ImageView backgroundview = new ImageView(backgroundimg);
        pane.getChildren().add(backgroundview);
        //Create a Button
        Button start = new Button();
        start.setLayoutX(450);
        start.setLayoutY(50);

        //Create imageview with background image
        ImageView view = new ImageView(new Image("https://i.imgur.com/Rjqi4yv.png"));
        view.setFitHeight(80);
        view.setPreserveRatio(true);
        //Attach image to the button
        start.setGraphic(view);
        //Set the image to the top
        start.setContentDisplay(ContentDisplay.TOP);

        //exit button
        Button exit = new Button();
        exit.setLayoutX(470);
        exit.setLayoutY(250);
        //Create imageview with background image
        ImageView view1 = new ImageView(new Image("https://i.imgur.com/HkDgkC6.png"));
        view1.setFitHeight(80);
        view1.setPreserveRatio(true);
        //Attach image to the button
        exit.setGraphic(view1);
        //Set the image to the top
        exit.setContentDisplay(ContentDisplay.TOP);
        exit.setOnAction((e) -> this.game_selection(stage));

        ImageView plateview = new ImageView(new Image("https://i.imgur.com/rqT5oNv.png"));
        plateview.setLayoutX(15);
        plateview.setLayoutY(15);
        plateview.setPreserveRatio(true);

        double[] points = { 200, 200.0d, 220.0d, 200.0d, 210.0d, 100d };
        Polygon triangle = new Polygon(points);
        triangle.setFill(Color.PINK);
        triangle.setStroke(Color.WHITE);
        triangle.setStrokeWidth(1);

        Circle circleCenter = new Circle(25);
        circleCenter.setLayoutX(210);
        circleCenter.setLayoutY(205);
        circleCenter.setStroke(Color.WHITE);
        circleCenter.setFill(Color.rgb(243, 119, 119, .99));
        circleCenter.setStrokeWidth(1);

        pane.getChildren().addAll(start,exit,plateview);
        pane.getChildren().addAll(triangle,circleCenter);
        start.setOnAction((e) -> {
            Random r = new Random();
            int x = r.nextInt(9);
            //讀exe
            try {
                Runtime.getRuntime().exec("beardplate.exe");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            //讀txt
            try {
                BufferedReader br = new BufferedReader(new FileReader("plate.txt"));
                String str1;
                str1 = br.readLine();
                prize = (parseInt (str1)+x)%9+1;
                System.out.println(prize);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            //獎勵
            if(prize == 1){
                //-6cm
                size = size -30;
            }
            else if(prize == 2){
                size = size -20;
            }
            else if(prize == 3){
                size+=15;
            }
            else if(prize == 4){
                ldr_beard = ldr_beard1;
            }
            else if(prize == 5){
                size-=10;
            }
            else if(prize == 6){
                ldr_beard = ldr_beard2;
            }
            else if(prize == 7){
                size+=25;
            }
            else if(prize == 8){
                ldr_beard = ldr_beard3;
            }
            else if(prize == 9){
                size+=5;
            }
            System.out.println(size);

            //轉動轉盤
            //播放持續時間
            double play_time=3.0;
            //開始角度
            double fromAngle=0.0;
            //結束角度
            double angle = 0;
            if(prize<lastprize){
                angle = 9-lastprize + prize;
            }
            else{
                angle = Math.abs(prize-lastprize);
            }
            double toAngle= fromAngle + 40 * angle;
            lastprize = prize;

            RotateTransition rotateTransition = new  RotateTransition(Duration.seconds(play_time),
                    plateview);
            //旋轉角度
            rotateTransition.setByAngle(1080+toAngle);

            if(size<=0){
                rotateTransition.play();
                rotateTransition.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        jail(stage);
                    }
                });

            }
            else rotateTransition.play();
        });

        Scene scene = new Scene(pane,640,400);
        stage.setTitle("幸運轉盤");
        stage.setScene(scene);
        stage.show();
    }
    public void horsemenu(Stage stage){
        Pane pane = new Pane();
        //background
        Image backgroundimg = new Image("https://i.imgur.com/x8VJW9z.png");
        ImageView backgroundview = new ImageView(backgroundimg);
        pane.getChildren().add(backgroundview);
        //horsebtn
        int btnx = 60;
        int interx = 90;
        int btny = 250;
        int intery = 100;
        Button btn1 = new Button("horse 1");
        Button btn2 = new Button("horse 2");
        Button btn3 = new Button("horse 3");
        Button btn4 = new Button("horse 4");
        Button btn5 = new Button("horse 5");
        Button btn6 = new Button("horse 6");
        Button btn7 = new Button("horse 7");
        Button btn8 = new Button("horse 8");
        Button btn9 = new Button("horse 9");
        Button btn10 = new Button("horse 10");
        Button btn11 = new Button("horse 11");
        Button btn12 = new Button("horse 12");
        btn1.setLayoutX(btnx+interx*0);
        btn1.setLayoutY(btny);
        btn2.setLayoutX(btnx+interx*1);
        btn2.setLayoutY(btny);
        btn3.setLayoutX(btnx+interx*2+10);
        btn3.setLayoutY(btny);
        btn4.setLayoutX(btnx+interx*3+30);
        btn4.setLayoutY(btny);
        btn5.setLayoutX(btnx+interx*4+30);
        btn5.setLayoutY(btny);
        btn6.setLayoutX(btnx+interx*5+30);
        btn6.setLayoutY(btny);
        btn7.setLayoutX(btnx+interx*0);
        btn7.setLayoutY(btny+intery);
        btn8.setLayoutX(btnx+interx*1);
        btn8.setLayoutY(btny+intery);
        btn9.setLayoutX(btnx+interx*2+10);
        btn9.setLayoutY(btny+intery);
        btn10.setLayoutX(btnx+interx*3+30);
        btn10.setLayoutY(btny+intery);
        btn11.setLayoutX(btnx+interx*4+30);
        btn11.setLayoutY(btny+intery);
        btn12.setLayoutX(btnx+interx*5+30);
        btn12.setLayoutY(btny+intery);
        Text choosetxt = new Text("Please choose the horse:");
        Text youchoose = new Text("You choose Horse:"+ bethorse);
        btn1.setOnAction((e) -> {
            bethorse = 1;
            youchoose.setText("You choose Horse:"+ bethorse);
        });
        btn2.setOnAction((e) -> {
            bethorse = 2;
            youchoose.setText("You choose Horse:"+ bethorse);
        });
        btn2.setOnAction((e) -> {
            bethorse = 2;
            youchoose.setText("You choose Horse:"+ bethorse);
        });
        btn3.setOnAction((e) -> {
            bethorse = 3;
            youchoose.setText("You choose Horse:"+ bethorse);
        });
        btn3.setOnAction((e) -> {
            bethorse = 3;
            youchoose.setText("You choose Horse:"+ bethorse);
        });
        btn4.setOnAction((e) -> {
            bethorse = 4;
            youchoose.setText("You choose Horse:"+ bethorse);
        });
        btn5.setOnAction((e) -> {
            bethorse = 5;
            youchoose.setText("You choose Horse:"+ bethorse);
        });
        btn6.setOnAction((e) -> {
            bethorse = 6;
            youchoose.setText("You choose Horse:"+ bethorse);
        });
        btn7.setOnAction((e) -> {
            bethorse = 7;
            youchoose.setText("You choose Horse:"+ bethorse);
        });
        btn8.setOnAction((e) -> {
            bethorse = 8;
            youchoose.setText("You choose Horse:"+ bethorse);
        });
        btn9.setOnAction((e) -> {
            bethorse = 9;
            youchoose.setText("You choose Horse:"+ bethorse);
        });
        btn10.setOnAction((e) -> {
            bethorse = 10;
            youchoose.setText("You choose Horse:"+ bethorse);
        });
        btn11.setOnAction((e) -> {
            bethorse = 11;
            youchoose.setText("You choose Horse:"+ bethorse);
        });
        btn12.setOnAction((e) -> {
            bethorse = 12;
            youchoose.setText("You choose Horse:"+ bethorse);
        });

        choosetxt.setLayoutX(270);
        choosetxt.setLayoutY(60);
        choosetxt.setFont(Font.font(30));
        youchoose.setLayoutX(270);
        youchoose.setLayoutY(90);
        youchoose.setFont(Font.font(30));
        pane.getChildren().addAll(choosetxt,youchoose);
        pane.getChildren().addAll(btn1, btn2, btn3, btn4, btn5, btn6,
                btn7, btn8, btn9, btn10, btn11, btn12);
        //Create a Button
        Button start = new Button();
        start.setLayoutX(100);
        start.setLayoutY(25);
        //Create imageview with background image
        ImageView view = new ImageView(new Image("https://i.imgur.com/Rjqi4yv.png"));
        view.setFitHeight(80);
        view.setPreserveRatio(true);
        //Attach image to the button
        start.setGraphic(view);
        //Set the image to the top
        start.setContentDisplay(ContentDisplay.TOP);
        start.setOnAction((e) -> {
            Random r = new Random();
            int x = r.nextInt(9);
            //讀exe
            try {
                Runtime.getRuntime().exec("beardhorse.exe");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            //讀txt
            try {
                BufferedReader br = new BufferedReader(new FileReader("horse.txt"));
                String str1;
                str1 = br.readLine();
                winhorse = (parseInt (str1) + x)%12+1;
                System.out.println(winhorse);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            try {
                this.horserace(stage);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });
        pane.getChildren().addAll(start);
        Scene scene = new Scene(pane,640,400);
        stage.setTitle("賽馬城");
        stage.setScene(scene);
        stage.show();
    }
    public void horserace(Stage stage) throws InterruptedException {
        Pane pane = new Pane();
        //background
        Image backgroundimg = new Image("https://i.imgur.com/KKUeDiJ.png");
        ImageView backgroundview = new ImageView(backgroundimg);
        pane.getChildren().add(backgroundview);
        //horse
        ImageView horse1 = new ImageView(new Image("https://i.imgur.com/fJCCXtY.png"));
        ImageView horse2 = new ImageView(new Image("https://i.imgur.com/4X1D4NS.png"));
        ImageView horse3 = new ImageView(new Image("https://i.imgur.com/65smbpx.png"));
        ImageView horse4 = new ImageView(new Image("https://i.imgur.com/5Qrvp23.png"));
        ImageView horse5 = new ImageView(new Image("https://i.imgur.com/ttRStAk.png"));
        ImageView horse6 = new ImageView(new Image("https://i.imgur.com/OmUgphh.png"));
        ImageView horse7 = new ImageView(new Image("https://i.imgur.com/9pQGK9I.png"));
        ImageView horse8 = new ImageView(new Image("https://i.imgur.com/sh47sEX.png"));
        ImageView horse9 = new ImageView(new Image("https://i.imgur.com/ghlFIjV.png"));
        ImageView horse10 = new ImageView(new Image("https://i.imgur.com/YyEaL0x.png"));
        ImageView horse11 = new ImageView(new Image("https://i.imgur.com/G7FTKef.png"));
        ImageView horse12 = new ImageView(new Image("https://i.imgur.com/HVknZdU.png"));
        int y = -33;
        int liney=0;
        horse1.setLayoutX(0);
        horse1.setLayoutY(y+=35);
        Line line1 = new Line(40,liney+=15,600,liney);
        line1.setVisible(false);

        horse2.setLayoutX(0);
        horse2.setLayoutY(y+=33);

        horse3.setLayoutX(0);
        horse3.setLayoutY(y+=33);

        horse4.setLayoutX(0);
        horse4.setLayoutY(y+=33);

        horse5.setLayoutX(0);
        horse5.setLayoutY(y+=33);

        horse6.setLayoutX(0);
        horse6.setLayoutY(y+=33);

        horse7.setLayoutX(0);
        horse7.setLayoutY(y+=33);

        horse8.setLayoutX(0);
        horse8.setLayoutY(y+=33);

        horse9.setLayoutX(0);
        horse9.setLayoutY(y+=33);

        horse10.setLayoutX(0);
        horse10.setLayoutY(y+=33);

        horse11.setLayoutX(0);
        horse11.setLayoutY(y+=33);

        horse12.setLayoutX(0);
        horse12.setLayoutY(y+=33);
        pane.getChildren().addAll(line1, horse1, horse2, horse3, horse4, horse5, horse6,
                horse7, horse8, horse9, horse10, horse11, horse12);

        playanimation(line1,horse1, 1);
        playanimation(line1,horse2, 2);
        playanimation(line1,horse3, 3);
        playanimation(line1,horse4, 4);
        playanimation(line1,horse5, 5);
        playanimation(line1,horse6, 6);
        playanimation(line1,horse7, 7);
        playanimation(line1,horse8, 8);
        playanimation(line1,horse9, 9);
        playanimation(line1,horse10, 10);
        playanimation(line1,horse11, 11);
        playanimation(line1,horse12, 12);
        pane.setOnMouseClicked(e -> {
            // 滑鼠左鍵
            if (e.getButton() == MouseButton.PRIMARY) {
                try {
                    this.horseresult(stage);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            pane.requestFocus(); //更新，才可收到鍵盤事件
        });

        Scene scene = new Scene(pane,640,400);
        stage.setTitle("馬兒蹦跳！");
        stage.setScene(scene);
        stage.show();
    }
    public void playanimation(Line line, ImageView horse, int iswinhorse) throws InterruptedException {
        //動畫路徑
        PathTransition pathTransition = new PathTransition();
        //播放持續時間
        if(iswinhorse==winhorse)    pathTransition.setDuration(Duration.millis(3000));
        else    pathTransition.setDuration(Duration.millis(4000+iswinhorse%5*76%11*100));

        //路徑為直線
        pathTransition.setPath(line);
        //動畫節點是horse
        pathTransition.setNode(horse);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        //跑一次
        pathTransition.setCycleCount(1);
        pathTransition.setAutoReverse(false);
        pathTransition.play();

    }
    public void horseresult(Stage stage) throws InterruptedException {
        Pane pane = new Pane();
        //background
        Image backgroundimg = new Image("https://i.imgur.com/yAIbreE.png");
        ImageView backgroundview = new ImageView(backgroundimg);
        //winhorse
        Text wintxt = new Text(Integer.toString(winhorse));
        Text result = new Text();
        Text prize = new Text();

        if(winhorse == bethorse){
            result.setText("You win!");
            size+=25;
            prize.setText("賀！你的鬍子生長了5公分！");
        }
        else{
            result.setText("You lose!");
            prize.setText("你的鬍子減少了1公分，幫QQ");
            size-=5;
        }
        result.setLayoutX(200);
        prize.setLayoutX(200);
        result.setLayoutY(260);
        prize.setLayoutY(295);
        result.setFont(Font.font(25));
        prize.setFont(Font.font(25));
        wintxt.setLayoutX(370);
        wintxt.setLayoutY(180);
        wintxt.setFont(Font.font("Lucida Handwriting",40.0D));
        wintxt.setRotate(6);
        pane.getChildren().addAll(backgroundview,wintxt,result,prize);
        Button exit = new Button();
        exit.setLayoutX(547);
        exit.setLayoutY(320);
        exit.setStyle("-fx-background-color: Transparent");

        //Create imageview with background image
        ImageView view1 = new ImageView(new Image("https://i.imgur.com/HkDgkC6.png"));
        view1.setFitHeight(80);
        view1.setPreserveRatio(true);
        //Attach image to the button
        exit.setGraphic(view1);
        //Set the image to the top
        exit.setContentDisplay(ContentDisplay.TOP);
        pane.getChildren().addAll(exit);
        exit.setOnAction((e) -> this.game_selection(stage));

        Scene scene = new Scene(pane,640,400);
        stage.setTitle("賽馬結果");
        stage.setScene(scene);
        stage.show();
        if(size<=0){

            Timeline tl = new Timeline(new KeyFrame(Duration.seconds(2),
                    new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent actionEvent) {

                    stage.show();
                }
            }));
              tl.setCycleCount(1);
            tl.play();
            tl.setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    jail(stage);
                }
            });

        }

    }
    public void game_selection(Stage stage){
        stage.setTitle("狂賭之鬍");
        //background//
        Image back_img = new Image("https://i.imgur.com/fCO4YmO.jpg");
        ImageView  back_imgv = new ImageView(back_img);
        back_imgv.setPreserveRatio(false);
        back_imgv.setFitHeight(400);
        back_imgv.setFitWidth(640);
        // ldr's beard//
        ImageView ldr_beardview = new ImageView(ldr_beard);
        ldr_beardview.setY(145);
        ldr_beardview.setX(500);
        if(size!=0)ldr_beardview.setFitHeight(size);
        else ldr_beardview.setVisible(false);
        //btn slot machine//
        Button btn_slot = new Button();

        Image slot_img = new Image("https://i.imgur.com/9WergAY.png");
        ImageView slot_imgv = new ImageView(slot_img);
        slot_imgv.setFitHeight(100);
        slot_imgv.setFitWidth(100);
        btn_slot.setGraphic(slot_imgv);
        btn_slot.setOnAction((e)->{
            try {
                this.slot_machine(stage);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });


        //button roulette//
        Button btn_roulette = new Button();

        Image roulette_img = new Image("https://i.imgur.com/W7ESfeS.png");
        ImageView roulette_imgv = new ImageView(roulette_img);
        roulette_imgv.setFitHeight(100);
        roulette_imgv.setFitWidth(100);
        btn_roulette.setGraphic(roulette_imgv);
        btn_roulette.setOnAction((e)->{
            this.plate(stage);
        });
        //button horse//
        Button btn_horse = new Button();
        Image horse_img = new Image("https://i.imgur.com/t7kPqiF.png");
        ImageView horse_imgv = new ImageView(horse_img);
        horse_imgv.setFitHeight(100);
        horse_imgv.setFitWidth(100);
        btn_horse.setGraphic(horse_imgv);
        btn_horse.setOnAction((e)->{
            this.horsemenu(stage);
        });


        // action event
        EventHandler<ActionEvent> event = new
                EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e)
                    {
                        Stage yousure = new Stage();
                        yousure.setTitle("Are you sure???");
                        Label lb = new Label();
                        lb.setText("你確定要離開刮鬍子娛樂城嗎?\n" +
                                "真的不想賭嗎? 很划算ㄟ");
                        lb.setLayoutY(20);
                        lb.setLayoutX(40);
                        Button leave = new Button("再賭就要沒鬍子了");
                        leave.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                yousure.close();
                                stage.close();
                                this.happyend(stage);
                            }

                            private void happyend(Stage stage) {

                                stage.setTitle("浪子回頭");
                                Image sea = new Image("https://i.imgur.com/r9PhpTS.jpg") ;
                                ImageView seaview = new ImageView(sea);
                                seaview.setFitWidth(640);
                                seaview.setFitHeight(400);
                                Button gameover = new Button();
                                gameover.setMinHeight(100);
                                gameover.setMinWidth(150);
                                gameover.setLayoutX(10);
                                gameover.setLayoutY(300);
                                gameover.setStyle("-fx-background-color: Transparent");
                                gameover.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent actionEvent) {
                                        stage.close();
                                    }
                                });
                                Pane root = new Pane();
                                root.getChildren().addAll(seaview,gameover);
                                stage.setScene(new Scene(root,640,400));
                                stage.show();
                            }
                        });
                        Button back = new Button("我要成為百鬍富翁!");
                        back.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                yousure.close();
                            }
                        });
                        back.setLayoutY(60); back.setLayoutX(10);
                        leave.setLayoutY(60); leave.setLayoutX(180);
                        Pane root = new Pane();
                        root.getChildren().addAll(lb,leave,back);
                        yousure.setScene(new Scene(root,300,100));
                        yousure.show();
                    }
                };
        //button exit//
        Button exit = new Button();
        exit.setStyle("-fx-background-color: Transparent");
        exit.setOnAction(event);
        exit.setMinHeight(80);
        exit.setMinWidth(40);
        exit.setLayoutX(540);
        exit.setLayoutY(0);
        // button in hbox//
        HBox hbox = new HBox();
        hbox.getChildren().addAll(btn_horse,btn_roulette,btn_slot);
        hbox.setLayoutX(30);
        hbox.setLayoutY(150);
        hbox.setSpacing(20);
        //pane//
        Pane root = new Pane();
        root.getChildren().addAll(back_imgv,hbox,exit,ldr_beardview);
        stage.setScene(new Scene(root, 640, 400));
        stage.show();
    }
    public void jail(Stage stage) {
        Pane pane = new Pane();
        //background
        Image backgroundimg = new Image("https://i.imgur.com/nBoVMQ4.png");
        ImageView backgroundview = new ImageView(backgroundimg);
        //text
        Text text = new Text();
        text.setText("很抱歉，由於沒有鬍子作為賭注，您卻還想繼續賭博，" +
                "\n毫無悔改之心，實在是太令人失望了！" +
                "\n因此，您即將前往監獄，祝您旅途愉快~");
        text.setLayoutX(330);
        text.setLayoutY(360);
        Rectangle rectangle = new Rectangle(300, 100);
        rectangle.setLayoutX(330);
        rectangle.setLayoutY(340);
        rectangle.setFill(Color.rgb(255, 255, 255, .4));
        Button exitbtn = new Button("前往監獄");
        exitbtn.setLayoutX(530);
        exitbtn.setLayoutY(0);
        exitbtn.setFont(Font.font(20.D));
        exitbtn.setOnAction(e->stage.close());
        pane.getChildren().addAll(backgroundview,rectangle,text,exitbtn);
        Scene scene = new Scene(pane,640,400);
        stage.setTitle("敬請期待【小鬍子監獄風雲】");
        stage.setScene(scene);
        stage.show();
    }
}