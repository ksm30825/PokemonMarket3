package controller;

import model.dao.UserDao;
import model.vo.User;

public class ItemManager {
	
	private MCManager mc = new MCManager();
	private UserDao ud;
	private User user;
	private UserManager um = new UserManager(user, ud);
	private int dG;
	
	
	
	
	public void decreaseGold(int check) {
		System.out.println("ItemMamager�� ��");
		//���� �Ѿ�, ���� ���� ���� �ݾ��� �����ͼ� �� ����ִ�
		System.out.println("�����Ѿ� : "+check);
		System.out.println("�� �� :"+um.getUserGold());
		dG = um.getUserGold() - check; 
		um.setUserGold(dG);
	}
	
	
	
	
	
	
	
	
	
	//��Ʋ���� �޾ƿ;� ��
	public void useStone() {
		
	}
	public void useBall() {
		
	}
	public void Recovery() {
		
	}
}
