package mainmenu;

import menuhelper.*;

public class MainMenu {
		public static void main(String[] args) {
			MenuHelper menu = new MenuHelper();
			String select;
			do {
				menu.printMenu();
				select = menu.select();
				if(select.equals("2")){
					menu.printCurrentListAPI();
					String selectApi = menu.select();
					menu.selectApi(selectApi);
				}				
			}while(!select.matches("0"));
			System.out.println("----------------Exit----------------------");
		}
}
