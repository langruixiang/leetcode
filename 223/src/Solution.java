public class Solution {
	class Rectangle{
		int A,B,C,D;
		public Rectangle(int a,int b,int c,int d){
			this.A = a;
			this.B = b;
			this.C = c;
			this.D = d;
		}
		
		public long area(){
			if(C <= A || D <= B){
				return 0;
			}
			
			return (C - A) * (D - B);
		}
		
	}
	
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        Rectangle rec1 = new Rectangle(A, B, C, D);
        Rectangle rec2 = new Rectangle(E, F, G, H);
        Rectangle rec3 = new Rectangle(Integer.max(A, E), Integer.max(B, F), Integer.min(C, G), Integer.min(D, H));
        
        return (int)(rec1.area() + rec2.area() - rec3.area());
    	
    }
}