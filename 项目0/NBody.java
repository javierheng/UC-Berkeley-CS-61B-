import java.util.*;

public class NBody{
	public static double readRadius(String filepath){
		double Radius;
		In in = new In(filepath);
		in.readDouble();
		Radius = in.readDouble();	
		return Radius;		
	}

	public static Body[] readBodies(String filepath){
		int planetsnumber ;
		int i = 0;

		In in = new In(filepath);
		planetsnumber = in.readInt();
		in.readDouble();
		Body[] planets;
		planets = new Body[planetsnumber];

		while(i < planetsnumber){
			planets[i] = new Body(in.readDouble() ,in.readDouble() ,in.readDouble() ,in.readDouble() ,in.readDouble() ,in.readString());

			i = i + 1;
		}
		return planets;
	}	
	
	public static void main(String args[]){
		double time = 0;
		double T;
		double dt;
		String filename;
		double Radius;
		Body[] Bodies;
		int i = 0;
		double[] xForces;
		double[] yForces;
		
		//信息输入部分
		Scanner in = new Scanner(System.in);
		T = Double.parseDouble(in.nextLine());
		dt = Double.parseDouble(in.nextLine());
		filename = in.nextLine();
		Radius = readRadius(filename);
		Bodies = readBodies(filename);
		
		xForces = new double[Bodies.length];
		yForces = new double[Bodies.length];
		//后面进入绘图部分
		//首先先设置画框比例
		StdDraw.setCanvasSize(800,800);
		StdDraw.setXscale(-Radius, +Radius);
		StdDraw.setYscale(-Radius, +Radius);
		//设置背景
		StdDraw.picture(0.0 , 0.0 , "./images/starfield.jpg" , Radius*2 , Radius*2);
		
		
		StdDraw.enableDoubleBuffering();
		
		while(time < T){
			
			i = 0;
			while(i < Bodies.length){
				xForces[i] = Bodies[i].calcNetForceExertedByX(Bodies);
				yForces[i] = Bodies[i].calcNetForceExertedByY(Bodies);
				//Bodies[i].draw();
				i = i + 1;
			}
			i = 0;
			while(i < Bodies.length){
				Bodies[i].update(dt, xForces[i], yForces[i]);
				i = i + 1;
			}
			
			StdDraw.picture(0.0 , 0.0 , "./images/starfield.jpg" , Radius*2 , Radius*2);
			
			i = 0;
			while(i < Bodies.length){
				Bodies[i].draw();
				i = i + 1;
			}
			
			StdDraw.show();
			StdDraw.pause(10);
			time = time + dt;	
		}

		System.out.println(Bodies.length);
		System.out.println(Radius);
		i = 0;
		while(i<Bodies.length){
			System.out.print(Bodies[i].xxPos);
			System.out.print(" ");
			System.out.print(Bodies[i].yyPos);
			System.out.print(" ");
			System.out.print(Bodies[i].xxVel);
			System.out.print(" ");
			System.out.print(Bodies[i].yyVel);
			System.out.print(" ");
			System.out.print(Bodies[i].mass);
			System.out.print(" ");
			System.out.print(Bodies[i].imgFileName);
			System.out.print("\n");
			i = i + 1;
		}
	}
}
