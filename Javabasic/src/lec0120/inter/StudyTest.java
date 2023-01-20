package lec0120.inter;

import com.ssafy.three.eleven.KimTaeHwan;
import com.ssafy.three.eleven.StudyMember;
import oop.member.*;

public class StudyTest {

	public static void main(String[] args) {
		
		StudyMember jsy = new JSY();
		jsy.age();
		jsy.bloodType();
		jsy.mbti();
		jsy.name();
		
		StudyMember kth = new KimTaeHwan();
		kth.age();
		kth.bloodType();
		kth.mbti();
		kth.name();
//		{
//			StudyMember sm = getInstance();
//			
//		}
//		static StudyMember getInstance() {
//			return new jsy();
//		}
	}

}
