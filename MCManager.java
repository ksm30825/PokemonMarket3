package controller;

import java.util.Date;

import model.dao.ItemDao;
import model.dao.UserDao;
import model.vo.User;

//����
//ü��ȸ��
public class MCManager {
	//����
	//���ż���üũ->�����ݾ�üũ->���Ű��ɿ��� üũ
	private String resultNo;
	
	public void useMarket(String itemName, int itemAmount) {
		ItemDao id = new ItemDao(); 
		//->MarketView���� �� ��
		//�ּҼ���, �ִ����
		User user = new User("�̸�",new Date(),100000);
		UserDao ud = new UserDao(user);
		UserManager um = new UserManager(user,ud);
		int check=0;//���� �ϰ� ���� ������ �ѷ��� ����
		
		ItemManager im = new ItemManager();
		resultNo=null;
		for(int i=0 ; i<id.getItemList().size() ; i++) {
			//������ �� ���� ���Ͽ� �����۸���Ʈ�� ���° �ε����� �ִ� �� Ȯ��
			if(id.getItemList().get(i).getiName().equals(itemName)) {
				//���� �ϰ� ���� �������� �� �ݾ�
				check=(id.getItemList().get(i).getiPrice())*itemAmount;
				//�����κ��� �ִ� �����ݾװ� �� ��	
				//�����ݾ�<check : �����ݾ��� ���� ���Ű� �Ұ��� �մϴ� ��� : MarketView���� �ٷ� �����
				if(um.getUserGold()<check) {
					//���� �Ұ�
					resultNo="�� ����";
				}else {
					//���� ����
					//�ߺ� �������� ������ ������ �������Ѿ�
					//System.out.println("������ : "+itemName+", ���� : "+itemAmount);
					im.decreaseGold(check);
				}
				//�����ݾ�>check : ���� ���� : itemManager �� ���� ��ϰ� �����Ѿ��� ������
			}
		}
		
	}
	public String getResultNo() {
		return resultNo;
	}
	public void setResultNo(String resultNo) {
		this.resultNo = resultNo;
	}
	public void useCenter() {
		//ȸ�� �����ֱ�
		
	}

}
