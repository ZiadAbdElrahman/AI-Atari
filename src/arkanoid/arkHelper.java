package arkanoid;

import atariCore.Helper;
import atariCore.Splash;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class arkHelper extends Helper {

	public static int ballScale = 6;
	public static int paddleScale = 4;
	public static int brickScale = 3;
	public static int capsuleScale = 5;

	public static final int INIT_BRICKS_HEIGHT = screenHeight * 40 / 100;
	public static final int INIT_PADDLE_X = screenWidth * 40 / 100;
	public static final int INIT_PADDLE_Y = screenHeight * 85 / 100;
	public static final int INIT_BALL_X = screenWidth * 43 / 100;
	public static final int INIT_BALL_Y = screenHeight * 82 / 100;
	public static int BRICKHITREWARD = 10;
	public static float paddleSpeed = 5;
	public static float initBallXSpeed = 1f;
	public static float initBallYSpeed = -2f;
	public static float xBallSpeed = 1f;
	public static float yBallSpeed = -2f;
	public static float capsuleSpeed = 1;
	public static float baseEnemyXSpeed = .1f;
	public static float baseEnemyYSpeed = .1f;
	
	public static Image[] normalBricks;
	public static Image[] brokenBricks;
	public static Image[] smallSquares;
	public static Image[] paddle;
	public static Image[] paddleWeapon;
	public static Image paddleShrunkWeapon;
	public static Image paddleShrunk;
	public static Image paddleExpanded;
	public static Image paddleExpandedWeapon;
	public static Image capsuleEmpty;
	public static Image capsule50;
	public static Image[] capsule100;
	public static Image capsule250;
	public static Image capsule500;
	public static Image capsuleSlow;
	public static Image capsuleFast;
	public static Image capsuleShrink;
	public static Image capsuleExpand;
	public static Image capsuleWeapon;
	public static Image capsuleFireBall;
	public static Image capsuleAcidBall;
	public static Image capsuleTripleBall;
	public static Image capsuleVaus;
	public static Image capsuleCatch;
	public static Image[] enemy;

	public static Image fireBall;
	public static Image acidBall;
	public static Image ball;
	public static Image star;
	public static Image life;
	public static Image bullet;
	public static String pathIamge = "src/Resources/image/";
	public static String pathLevel = "src/Resources/Files/levels.txt";
	public static String pathLeaderboards = "src/Resources/Files/Leaderboards.txt";
	// public static Image backgroundImage ;
	public static Image[] backgroundImage;
	public static int numberOfBrics = 2;
	public static arkFile arkfile;


	public arkHelper() {

		paddle = new Image[3];
		capsule100 = new Image[7];
		paddleWeapon = new Image[3];
		normalBricks = new Image[10];
		brokenBricks = new Image[10];
		smallSquares = new Image[10];
		backgroundImage = new Image[8];
		enemy = new Image[6];

		arkfile = new arkFile();

		loadImages();
	}

	private void loadImages() {

		for (int i = 1; i <= 20; i++) {
			if (i % 2 == 1) {
				normalBricks[i / 2] = getImage(pathIamge + (i < 10 ? "0" + i : i) + "-Breakout-Tiles.png", brickScale);
			} else {
				brokenBricks[i / 2 - 1] = getImage(pathIamge + (i < 10 ? "0" + i : i) + "-Breakout-Tiles.png", brickScale);
			}
		}

		for (int i = 21; i <= 30; i++) {
			smallSquares[i - 21] = getImage(pathIamge + i + "-Breakout-Tiles.png", brickScale);
		}

		capsule50 = getImage(pathIamge + "31-Breakout-Tiles.png", capsuleScale);

		for (int i = 32; i <= 38; i++) {
			capsule100[i - 32] = getImage(pathIamge + i + "-Breakout-Tiles.png", capsuleScale);
		}

		capsule250 = getImage(pathIamge + "39-Breakout-Tiles.png", capsuleScale);
		capsule500 = getImage(pathIamge + "40-Breakout-Tiles.png", capsuleScale);
		capsuleSlow = getImage(pathIamge + "41-Breakout-Tiles.png", capsuleScale);
		capsuleFast = getImage(pathIamge + "42-Breakout-Tiles.png", capsuleScale);
		capsuleTripleBall = getImage(pathIamge + "43-Breakout-Tiles.png", capsuleScale);
		capsuleFireBall = getImage(pathIamge + "44-Breakout-Tiles.png", capsuleScale);
		capsuleAcidBall = getImage(pathIamge + "45-Breakout-Tiles.png", capsuleScale);
		capsuleShrink = getImage(pathIamge + "46-Breakout-Tiles.png", capsuleScale);
		capsuleExpand = getImage(pathIamge + "47-Breakout-Tiles.png", capsuleScale);
		capsuleWeapon = getImage(pathIamge + "48-Breakout-Tiles.png", capsuleScale);
		capsuleEmpty = getImage(pathIamge + "49-Breakout-Tiles.png", capsuleScale);

		for (int i = 50; i <= 52; i++) {
			paddle[i - 50] = getImage(pathIamge + i + "-Breakout-Tiles.png", paddleScale);
		}

		for (int i = 53; i <= 55; i++) {
			paddleWeapon[i - 53] = getImage(pathIamge + i + "-Breakout-Tiles.png", paddleScale);
		}

		paddleExpanded = getImage(pathIamge + "56-Breakout-Tiles.png", paddleScale);
		paddleShrunk = getImage(pathIamge + "57-Breakout-Tiles.png", paddleScale);
		paddleShrunkWeapon = getImage(pathIamge + "65-Breakout-Tiles.png", paddleScale);
		ball = getImage(pathIamge + "58-Breakout-Tiles.png", ballScale);
		star = getImage(pathIamge + "59-Breakout-Tiles.png", ballScale);
		life = getImage(pathIamge + "60-Breakout-Tiles.png", ballScale);
		bullet = getImage(pathIamge + "61-Breakout-Tiles.png", brickScale);
		paddleExpandedWeapon = getImage(pathIamge + "62-Breakout-Tiles.png", paddleScale);
		fireBall = getImage(pathIamge + "63-Breakout-Tiles.png", ballScale);
		acidBall = getImage(pathIamge + "64-Breakout-Tiles.png", ballScale);
		capsuleCatch = getImage(pathIamge + "66-Breakout-Tiles.png", capsuleScale);
		capsuleVaus = getImage(pathIamge + "67-Breakout-Tiles.png", capsuleScale);

		for (int i = 1; i <= 8; i++) {
			backgroundImage[i - 1] = getImage(pathIamge + "background/" + i + ".jpg", 1);

		}

		for(int i = 1 ;i <=6 ; i++)
		{
			enemy[i-1] = getImage(pathIamge+"enemy/"+i+".png",1);
		}


	}

}
