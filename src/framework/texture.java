package framework;

import game_dev1.BufferedImageLoader;
import game_dev1.game;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;

public class texture {
    public BufferedImage block;
    public BufferedImage temp_bim[]=new BufferedImage[4];
    public BufferedImage demnboss[]=new BufferedImage[5];
    public BufferedImage player[]=new BufferedImage[13];
    public BufferedImage player_jump[]=new BufferedImage[28];
    public BufferedImage playerB_w[]=new BufferedImage[13];
    public BufferedImage back_ground[]=new BufferedImage[3];
    public BufferedImage enemy[]=new BufferedImage[10];
    public BufferedImage enemy_b[]=new BufferedImage[10];
    public BufferedImage bullet[]=new BufferedImage[2];
    public BufferedImage player_action[]=new BufferedImage[24];
    sprites bs,ps,es,blts,bgs,eboss,tmp_bl;
    BufferedImageLoader loader=new BufferedImageLoader();

    public texture()
    {
        BufferedImage bolcks=loader.loadimage("resource\\blocks.png");
        BufferedImage player=loader.loadimage("resource\\Player2.png");
        BufferedImage enemy=loader.loadimage("resource\\newdemon.png");
        BufferedImage bullet=loader.loadimage("resource\\bulet.png");
        BufferedImage back=loader.loadimage("resource\\newback.png");
        BufferedImage boss=loader.loadimage("resource\\boss2.png");
        BufferedImage temp_b=loader.loadimage("resource\\etc.png");

        bs=new sprites(bolcks);
        ps=new sprites(player);
        es=new sprites(enemy);
        blts=new sprites(bullet);
        bgs=new sprites(back);
        eboss=new sprites(boss);
        tmp_bl=new sprites(temp_b);
        gettexture();
    }
    public void gettexture(){
        temp_bim[0]=tmp_bl.picsubimage(20,20,80,25);
        temp_bim[1]=tmp_bl.picsubimage(123,115,30,33);
        temp_bim[2]=tmp_bl.picsubimage(5,100,60,70);

        demnboss[0]=eboss.picsubimage(6,435,80,130);
        demnboss[1]=eboss.picsubimage(87,435,90,130);
        demnboss[2]=eboss.picsubimage(309,420,100,120);
        demnboss[3]=eboss.picsubimage(430,435,120,120);
        demnboss[4]=eboss.picsubimage(225,13,80,90);



        //actions
        player_action[0]=ps.picsubimage(15,640,60,80);
        player_action[1]=ps.picsubimage(82,640,70,80);
        player_action[2]=ps.picsubimage(165,640,109,85);
        player_action[3]=ps.picsubimage(280,645,109,85);
        player_action[4]=ps.picsubimage(404,645,80,80);
        player_action[5]=ps.picsubimage(510,645,70,90);
        player_action[6]=ps.picsubimage(600,645,70,90);
        player_action[7]=ps.picsubimage(685,645,90,90);
        player_action[8]=ps.picsubimage(6,753,80,80);
        player_action[9]=ps.picsubimage(110,753,110,80);
        player_action[10]=ps.picsubimage(230,750,70,80);
        player_action[11]=ps.picsubimage(335,750,70,80);

        player_action[12]=ps.picsubimage(1905,640,60,80);
        player_action[13]=ps.picsubimage(1820,640,70,80);
        player_action[14]=ps.picsubimage(1690,640,109,85);
        player_action[15]=ps.picsubimage(1575,645,109,85);
        player_action[16]=ps.picsubimage(1485,645,80,80);
        player_action[17]=ps.picsubimage(1400,645,70,90);
        player_action[18]=ps.picsubimage(1300,645,70,90);
        player_action[19]=ps.picsubimage(1202,645,90,90);
        player_action[20]=ps.picsubimage(1880,753,80,80);
        player_action[21]=ps.picsubimage(1745,753,110,80);
        player_action[22]=ps.picsubimage(1662,750,70,80);
        player_action[23]=ps.picsubimage(1562,750,70,80);


        //movings
        player[0]=ps.picsubimage(5,5,70,95);
        player[1]=ps.picsubimage(154,5,70,95);
        player[2]=ps.picsubimage(227,5,80,95);
        player[3]=ps.picsubimage(315,5,70,95);
        player[4]=ps.picsubimage(390,5,70,95);
        player[5]=ps.picsubimage(460,5,70,95);
        player[6]=ps.picsubimage(535,5,85,95);
        player[7]=ps.picsubimage(620,5,70,95);
        player[8]=ps.picsubimage(700,5,70,95);
        //fall
        player[9]=ps.picsubimage(440,360,80,95);
        player[10]=ps.picsubimage(534,360,90,95);
        player[11]=ps.picsubimage(811,360,90,95);
        player[12]=ps.picsubimage(103,358,55,100);

        playerB_w[0]=ps.picsubimage(1900,5,70,95);
        playerB_w[1]=ps.picsubimage(1750,5,70,95);
        playerB_w[2]=ps.picsubimage(1677,5,80,95);
        playerB_w[3]=ps.picsubimage(1590,5,70,95);
        playerB_w[4]=ps.picsubimage(1515,5,70,95);
        playerB_w[5]=ps.picsubimage(1440,5,70,95);
        playerB_w[6]=ps.picsubimage(1354,5,85,95);
        playerB_w[7]=ps.picsubimage(1275,5,70,95);
        playerB_w[8]=ps.picsubimage(1190,5,70,95);
        //fall
        playerB_w[9]=ps.picsubimage(1440,360,80,95);
        playerB_w[10]=ps.picsubimage(1340,360,90,95);
        playerB_w[11]=ps.picsubimage(1060,360,90,95);
        playerB_w[12]=ps.picsubimage(1815,360,55,100);

        player_jump[0]=ps.picsubimage(700,110,70,100);
        player_jump[1]=ps.picsubimage(5,191,70,100);
        player_jump[2]=ps.picsubimage(75,200,70,100);
        player_jump[3]=ps.picsubimage(1200,110,70,100);
        player_jump[4]=ps.picsubimage(1900,191,70,100);
        player_jump[5]=ps.picsubimage(1830,200,70,100);
        player_jump[6]=ps.picsubimage(220,354,70,100);
        player_jump[7]=ps.picsubimage(300,354,70,100);
        player_jump[8]=ps.picsubimage(1670,354,70,100);
        player_jump[9]=ps.picsubimage(1590,354,70,100);

        player_jump[10]=ps.picsubimage(405,840,70,100);//right
        player_jump[11]=ps.picsubimage(495,840,100,120);
        player_jump[12]=ps.picsubimage(625,840,100,120);
        player_jump[13]=ps.picsubimage(740,840,70,110);
        player_jump[14]=ps.picsubimage(845,840,70,110);
        player_jump[15]=ps.picsubimage(15,965,80,110);
        player_jump[16]=ps.picsubimage(125,965,90,110);
        player_jump[17]=ps.picsubimage(250,965,70,110);
        player_jump[18]=ps.picsubimage(320,965,70,110);

        player_jump[19]=ps.picsubimage(1498,840,70,100);//right
        player_jump[20]=ps.picsubimage(1370,840,100,120);
        player_jump[21]=ps.picsubimage(1250,840,100,120);
        player_jump[22]=ps.picsubimage(1135,840,70,110);
        player_jump[23]=ps.picsubimage(1041,840,70,110);
        player_jump[24]=ps.picsubimage(1870,965,80,110);
        player_jump[25]=ps.picsubimage(1760,965,90,110);
        player_jump[26]=ps.picsubimage(1672,965,70,110);
        player_jump[27]=ps.picsubimage(1580,965,70,110);


       // player_jump[3]=ps.picsubimage(75,300,70,100);
        enemy[4]=es.picsubimage(220,510,70,100);
        enemy[0]=es.picsubimage(507,510,60,100);
        enemy[1]=es.picsubimage(437,510,70,100);
        enemy[2]=es.picsubimage(355,510,80,100);
        enemy[3]=es.picsubimage(286,510,70,100);//walking

        enemy_b[4]=es.picsubimage(1205,510,70,100);
        enemy_b[0]=es.picsubimage(917,510,60,100);
        enemy_b[1]=es.picsubimage(970,510,70,100);
        enemy_b[2]=es.picsubimage(1040,510,80,100);
        enemy_b[3]=es.picsubimage(1130,510,70,100);//walking_b

        enemy[5]=es.picsubimage(525,225,65,100);
        enemy[6]=es.picsubimage(215,225,80,100);
        enemy[7]=es.picsubimage(300,225,80,100);
        enemy[8]=es.picsubimage(380,225,120,100);
        enemy[9]=es.picsubimage(630,225,80,100);//attacking

        enemy_b[5]=es.picsubimage(890,225,65,100);
        enemy_b[6]=es.picsubimage(1189,225,80,100);
        enemy_b[7]=es.picsubimage(1106,225,80,100);
        enemy_b[8]=es.picsubimage(978,225,120,100);
        enemy_b[9]=es.picsubimage(778,225,80,100);//attacking_b
        //bullet pics
        bullet[0]=blts.picsubimage(60,60,2,2);
        bullet[1]=blts.picsubimage(0,0,50,30);



        block=bs.subimage(1,1,16,16);
        //background
        back_ground[0]=bgs.picsubimage(0,0,800,600);
        back_ground[1]=bgs.picsubimage(0,630,800,600);
        back_ground[2]=bgs.picsubimage(0,1250,800,600);

    }
}
