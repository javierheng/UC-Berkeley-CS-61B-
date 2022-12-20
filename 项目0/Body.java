public class Body{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	public static void main(String[] args){
		
	}

	public Body(double xp, double yp, double xv, double yv, double m, String img){
		xxPos = xp;
		yyPos = yp;
		xxVel = xv;
		yyVel = yv;
		mass = m;
		imgFileName = img;
	}

	public Body(Body b){
		this.xxPos = b.xxPos;
		this.yyPos = b.yyPos;
		this.xxVel = b.xxVel;
		this.yyVel = b.yyVel;
		this.mass = b.mass;
		this.imgFileName = b.imgFileName;
	}

	public double calcDistance(Body rocinante){	
		double Distance;
		Distance = Math.pow(this.xxPos - rocinante.xxPos,2.0)+Math.pow(this.yyPos - rocinante.yyPos,2.0);
		Distance=Math.sqrt(Distance);
		return Distance;
	}

	public double calcForceExertedBy(Body rocinante){
		double F;
		double r = this.calcDistance(rocinante);
		F = (6.67e-11*this.mass*rocinante.mass)/Math.pow(r,2.0);
		
		return F;
	}

	public double calcForceExertedByX(Body ABody){
		double Fx ;
		double F  ;
		double dx ;
		double r  ;

		F = this.calcForceExertedBy(ABody);
		if(this.xxPos>ABody.xxPos)dx = this.xxPos - ABody.xxPos;
		else dx = ABody.xxPos - this.xxPos;
		r = this.calcDistance(ABody);
		Fx = F*dx/r;
		return Fx;
	}


	public double calcForceExertedByY(Body ABody){
		double Fy ;
		double F  ;
		double dy ;
		double r  ;

		F = this.calcForceExertedBy(ABody);
		if(this.yyPos>ABody.yyPos)dy = this.yyPos - ABody.yyPos;
		else dy = ABody.yyPos - this.yyPos;
		r = this.calcDistance(ABody);
		Fy = F*dy/r;
		return Fy;
	}
	
	public double calcNetForceExertedByX(Body[] allBodys){
		double Fnetx=0.0;
		int i = 0;

		while(i < allBodys.length){
			if(this.equals(allBodys[i])){
				i=i+1;
				continue;
			}
			if(this.xxPos > allBodys[i].xxPos){
				Fnetx = Fnetx - this.calcForceExertedByX(allBodys[i]);
			}else{
				Fnetx = Fnetx + this.calcForceExertedByX(allBodys[i]);
			}
			i=i+1;
		}
		return Fnetx;
	}

	public double calcNetForceExertedByY(Body[] allBodys){
		double Fnety=0.0;
		int i=0;

		while(i < allBodys.length){
			if(this.equals(allBodys[i])){
				i=i+1;
				continue;
			}
			if(this.yyPos > allBodys[i].yyPos){
				Fnety = Fnety - this.calcForceExertedByY(allBodys[i]);
			}else{
				Fnety = Fnety + this.calcForceExertedByY(allBodys[i]);
			}
			i=i+1;
		}
		return Fnety;
	}

	public void update(double time, double fx, double fy){
		double anetx = fx/this.mass;
		double anety = fy/this.mass;
		
		this.xxVel = this.xxVel + time*anetx;
		this.yyVel = this.yyVel + time*anety;

		this.xxPos = this.xxPos + time*this.xxVel;
		this.yyPos = this.yyPos + time*this.yyVel;	
	}

	public void draw(){
		StdDraw.picture(this.xxPos , this.yyPos , this.imgFileName);	
	}
}
