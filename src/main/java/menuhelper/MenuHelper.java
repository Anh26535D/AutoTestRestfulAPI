package menuhelper;

import java.util.Scanner;

import apitest.*;

public class MenuHelper {
		
		public void printMenu() {
			System.out.println("==============MENU==============\r\n"
					+ "1) Select base URL (Default: https://auctions-app-2.herokuapp.com/api)\r\n"
					+ "2) Select API that need testing\r\n"
					+ "3) Run many-test or full-test mode API\r\n"
					+ "");
		}
		
		public void printCurrentListAPI() {
			System.out.println("==============API==============\r\n"
					+ "1.	uploadStatus\r\n"
					+ "2.	uploadFiles\r\n"
					+ "3.	login\r\n"
					+ "4.	sign_up\r\n"
					+ "5.	edit_account\r\n"
					+ "6.	logout\r\n"
					+ "7.	change_passsword\r\n"
					+ "8.	info\r\n"
					+ "9.	get_list_auctions\r\n"
					+ "10.	get_detail_auction\r\n"
					+ "11.	create_auction\r\n"
					+ "12.	edit_auction\r\n"
					+ "13.	delete_auction\r\n"
					+ "14.	info_auction\r\n"
					+ "15.	create_item\r\n"
					+ "16.	edit_item\r\n"
					+ "17.	info_item\r\n"
					+ "18.	create_comment\r\n"
					+ "19.	delete_comment\r\n"
					+ "20.	get_list_comments\r\n"
					+ "21.	create_bid\r\n"
					+ "22.	get_list_bids\r\n"
					+ "23.	get_list_categoires\r\n"
					+ "24.	get_list_brands\r\n"
					+ "25.	accept_max_bid\r\n"
					+ "26.	contact_us\r\n"
					+ "27.	like_auction\r\n"
					+ "28.	get_list_likes\r\n"
					+ "29.	total_likes_of_auction\r\n"
					+ "30.	get_news\r\n"
					+ "31.	read_new\r\n"
					+ "32.	get_notifications\r\n"
					+ "33.	read_notifications\r\n"
					+ "34.	get_slider\r\n"
					+ "35.	search\r\n"
					+ "36.	delete_notification\r\n"
					+ "37.	get_list_chat\r\n"
					+ "38.	create_chat\r\n"
					+ "39.	create_message_of_chat\r\n"
					+ "40.	get_list_message_of_chat\r\n"
					+ "41.	delivery\r\n"
					+ "");
		}
		
		public String select() {
			Scanner input = new Scanner(System.in);
			System.out.println("Enter your choice: ");
			String userSelect = input.nextLine();
			return userSelect;
		}
		
		public void selectApi(String select) {
			switch(select) {
			case "3":
					System.out.println("Run all or some tests, 0 for all-mode and other number for others (i for i-th test)");
					String selectMode = this.select();
					LoginTest loginTest = new LoginTest();
					loginTest.chooseTest(selectMode);
					break;
			case "4":
					System.out.println("Run all or some tests, 0 for all-mode and other number for others (i for i-th test)");
					selectMode = this.select();
					SignupTest signup = new SignupTest();
					signup.chooseTest(selectMode);
					break;
			case "5":
					System.out.println("Run all or some tests, 0 for all-mode and other number for others (i for i-th test)");
					selectMode = this.select();
					EditAccountTest edit = new EditAccountTest();
					edit.chooseTest(selectMode);
					break;
			case "6":
					System.out.println("Run all or some tests, 0 for all-mode and other number for others (i for i-th test)");
					selectMode = this.select();
					LogoutTest logoutTest = new LogoutTest();
					logoutTest.chooseTest(selectMode);
					break;
			case "7":
					System.out.println("Run all or some tests, 0 for all-mode and other number for others (i for i-th test)");
					selectMode = this.select();
					ChangePassTest change = new ChangePassTest();
					change.chooseTest(selectMode);
					break;
			case "8":
					System.out.println("Run all or some tests, 0 for all-mode and other number for others (i for i-th test)");
					selectMode = this.select();
					InfoTest info = new InfoTest();
					info.chooseTest(selectMode);
					break;
			case "9":
					System.out.println("Run all or some tests, 0 for all-mode and other number for others (i for i-th test)");
					selectMode = this.select();
					GetListAuctionsTest listAuctions = new GetListAuctionsTest();
					listAuctions.chooseTest(selectMode);
					break;
			case "10":
					System.out.println("Run all or some tests, 0 for all-mode and other number for others (i for i-th test)");
					selectMode = this.select();
					GetDetailAuctionsTest detailAuctions = new GetDetailAuctionsTest();
					detailAuctions.chooseTest(selectMode);
					break;
			case "11":
					System.out.println("Run all or some tests, 0 for all-mode and other number for others (i for i-th test)");
					selectMode = this.select();
					CreateAuctionTest creAuctions = new CreateAuctionTest();
					creAuctions.chooseTest(selectMode);
					break;
			case "12":
					System.out.println("Run all or some tests, 0 for all-mode and other number for others (i for i-th test)");
					selectMode = this.select();
					EditAuctionTest editAuctions = new EditAuctionTest();
					editAuctions.chooseTest(selectMode);
					break;
			case "13":
					System.out.println("Run all or some tests, 0 for all-mode and other number for others (i for i-th test)");
					selectMode = this.select();
					DeleteAuctionTest delAuction = new DeleteAuctionTest();
					delAuction.chooseTest(selectMode);
					break;			
			case "14":
					System.out.println("Run all or some tests, 0 for all-mode and other number for others (i for i-th test)");
					selectMode = this.select();
					InfoAuctionTest infoAuction = new InfoAuctionTest();
					infoAuction.chooseTest(selectMode);
					break;
			case "15":
					System.out.println("Run all or some tests, 0 for all-mode and other number for others (i for i-th test)");
					selectMode = this.select();
					CreateItemTest creItem = new CreateItemTest();
					creItem.chooseTest(selectMode);
					break;		
			case "17":
					System.out.println("Run all or some tests, 0 for all-mode and other number for others (i for i-th test)");
					selectMode = this.select();
					InfoItemTest infoItem = new InfoItemTest();
					infoItem.chooseTest(selectMode);
					break;		
			case "18":
					System.out.println("Run all or some tests, 0 for all-mode and other number for others (i for i-th test)");
					selectMode = this.select();
					CreateCommentTest creCmt = new CreateCommentTest();
					creCmt.chooseTest(selectMode);
					break;
			case "20":
					System.out.println("Run all or some tests, 0 for all-mode and other number for others (i for i-th test)");
					selectMode = this.select();
					GetListCommentsTest listCmt = new GetListCommentsTest();
					listCmt.chooseTest(selectMode);
					break;
			case "21":
					System.out.println("Run all or some tests, 0 for all-mode and other number for others (i for i-th test)");
					selectMode = this.select();
					CreateBidTest creBid = new CreateBidTest();
					creBid.chooseTest(selectMode);
					break;
			case "23":
					System.out.println("Run all or some tests, 0 for all-mode and other number for others (i for i-th test)");
					selectMode = this.select();
					GetListCategoriesTest listCate = new GetListCategoriesTest();
					listCate.chooseTest(selectMode);
					break;
			case "24":
					System.out.println("Run all or some tests, 0 for all-mode and other number for others (i for i-th test)");
					selectMode = this.select();
					GetListBrandsTest listBrands = new GetListBrandsTest();
					listBrands.chooseTest(selectMode);
					break;
			case "27":
					System.out.println("Run all or some tests, 0 for all-mode and other number for others (i for i-th test)");
					selectMode = this.select();
					LikeAuctionTest likeAuction = new LikeAuctionTest();
					likeAuction.chooseTest(selectMode);
					break;
			case "28":
					System.out.println("Run all or some tests, 0 for all-mode and other number for others (i for i-th test)");
					selectMode = this.select();
					GetListLikesTest listLikes = new GetListLikesTest();
					listLikes.chooseTest(selectMode);
					break;
			case "29":
					System.out.println("Run all or some tests, 0 for all-mode and other number for others (i for i-th test)");
					selectMode = this.select();
					TotalLikeOfAuctionTest totalLike = new TotalLikeOfAuctionTest();
					totalLike.chooseTest(selectMode);
					break;
			case "30":
					System.out.println("Run all or some tests, 0 for all-mode and other number for others (i for i-th test)");
					selectMode = this.select();
					GetNewsTest getNews = new GetNewsTest();
					getNews.chooseTest(selectMode);
					break;
			case "31":
					System.out.println("Run all or some tests, 0 for all-mode and other number for others (i for i-th test)");
					selectMode = this.select();
					ReadNewTest readNew = new ReadNewTest();
					readNew.chooseTest(selectMode);
					break;
			case "32":
					System.out.println("Run all or some tests, 0 for all-mode and other number for others (i for i-th test)");
					selectMode = this.select();
					GetNotificationsTest getNoti = new GetNotificationsTest();
					getNoti.chooseTest(selectMode);
					break;
			case "33":
					System.out.println("Run all or some tests, 0 for all-mode and other number for others (i for i-th test)");
					selectMode = this.select();
					ReadNotificationsTest readNoti = new ReadNotificationsTest();
					readNoti.chooseTest(selectMode);
					break;
			case "34":
					System.out.println("Run all or some tests, 0 for all-mode and other number for others (i for i-th test)");
					selectMode = this.select();
					GetSliderTest getSlider = new GetSliderTest();
					getSlider.chooseTest(selectMode);
					break;
			case "35":
					System.out.println("Run all or some tests, 0 for all-mode and other number for others (i for i-th test)");
					selectMode = this.select();
					SearchTest search = new SearchTest();
					search.chooseTest(selectMode);
					break;
			case "36":
					System.out.println("Run all or some tests, 0 for all-mode and other number for others (i for i-th test)");
					selectMode = this.select();
					DeleteNotificationTest del = new DeleteNotificationTest();
					del.chooseTest(selectMode);
					break;
			case "37":
					System.out.println("Run all or some tests, 0 for all-mode and other number for others (i for i-th test)");
					selectMode = this.select();
					GetListChatTest listChat = new GetListChatTest();
					listChat.chooseTest(selectMode);
					break;
			case "41":
					System.out.println("Run all or some tests, 0 for all-mode and other number for others (i for i-th test)");
					selectMode = this.select();
					DeliveryTest delivery = new DeliveryTest();
					delivery.chooseTest(selectMode);
					break;
				
			}
	}
}