package menuhelper;

import java.util.Scanner;

import apitest.*;

public class MenuHelper {
		
		public void printMenu() {
			System.out.println("==============MENU==============\r\n"
					+ "1) Select base URL (Default: https://auctions-app-2.herokuapp.com/api)\r\n"
					+ "2) Select API that need testing\r\n"
					+ "3) Run many-test or full-test mode API\r\n"
					+ "0) Exit"
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
					System.out.println("Run a test (0 for all)");
					String selectMode = this.select();
					LoginTest loginTest = new LoginTest();
					loginTest.chooseTest(selectMode);
					break;
			case "4":
					System.out.println("Run a test (0 for all)");
					selectMode = this.select();
					SignupTest signup = new SignupTest();
					signup.chooseTest(selectMode);
					break;
			case "5":
					System.out.println("Run a test (0 for all)");
					selectMode = this.select();
					EditAccountTest edit = new EditAccountTest();
					edit.chooseTest(selectMode);
					break;
			case "6":
					System.out.println("Run a test (0 for all)");
					selectMode = this.select();
					LogoutTest logoutTest = new LogoutTest();
					logoutTest.chooseTest(selectMode);
					break;
			case "7":
					System.out.println("Run a test (0 for all)");
					selectMode = this.select();
					ChangePassTest change = new ChangePassTest();
					change.chooseTest(selectMode);
					break;
			case "8":
					System.out.println("Run a test (0 for all)");
					selectMode = this.select();
					InfoTest info = new InfoTest();
					info.chooseTest(selectMode);
					break;
			case "9":
					System.out.println("Run a test (0 for all)");
					selectMode = this.select();
					GetListAuctionsTest listAuctions = new GetListAuctionsTest();
					listAuctions.chooseTest(selectMode);
					break;
			case "10":
					System.out.println("Run a test (0 for all)");
					selectMode = this.select();
					GetDetailAuctionsTest detailAuctions = new GetDetailAuctionsTest();
					detailAuctions.chooseTest(selectMode);
					break;
			case "11":
					System.out.println("Run a test (0 for all)");
					selectMode = this.select();
					CreateAuctionTest creAuctions = new CreateAuctionTest();
					creAuctions.chooseTest(selectMode);
					break;
			case "12":
					System.out.println("Run a test (0 for all)");
					selectMode = this.select();
					EditAuctionTest editAuctions = new EditAuctionTest();
					editAuctions.chooseTest(selectMode);
					break;
			case "13":
					System.out.println("Run a test (0 for all)");
					selectMode = this.select();
					DeleteAuctionTest delAuction = new DeleteAuctionTest();
					delAuction.chooseTest(selectMode);
					break;			
			case "14":
					System.out.println("Run a test (0 for all)");
					selectMode = this.select();
					InfoAuctionTest infoAuction = new InfoAuctionTest();
					infoAuction.chooseTest(selectMode);
					break;
			case "15":
					System.out.println("Run a test (0 for all)");
					selectMode = this.select();
					CreateItemTest creItem = new CreateItemTest();
					creItem.chooseTest(selectMode);
					break;		
			case "17":
					System.out.println("Run a test (0 for all)");
					selectMode = this.select();
					InfoItemTest infoItem = new InfoItemTest();
					infoItem.chooseTest(selectMode);
					break;		
			case "18":
					System.out.println("Run a test (0 for all)");
					selectMode = this.select();
					CreateCommentTest creCmt = new CreateCommentTest();
					creCmt.chooseTest(selectMode);
					break;
			case "20":
					System.out.println("Run a test (0 for all)");
					selectMode = this.select();
					GetListCommentsTest listCmt = new GetListCommentsTest();
					listCmt.chooseTest(selectMode);
					break;
			case "21":
					System.out.println("Run a test (0 for all)");
					selectMode = this.select();
					CreateBidTest creBid = new CreateBidTest();
					creBid.chooseTest(selectMode);
					break;
			case "22":
					System.out.println("Run a test (0 for all)");
					selectMode = this.select();
					GetListBidsTest listbid = new GetListBidsTest();
					listbid.chooseTest(selectMode);
					break;
			case "23":
					System.out.println("Run a test (0 for all)");
					selectMode = this.select();
					GetListCategoriesTest listCate = new GetListCategoriesTest();
					listCate.chooseTest(selectMode);
					break;
			case "24":
					System.out.println("Run a test (0 for all)");
					selectMode = this.select();
					GetListBrandsTest listBrands = new GetListBrandsTest();
					listBrands.chooseTest(selectMode);
					break;
			case "27":
					System.out.println("Run a test (0 for all)");
					selectMode = this.select();
					LikeAuctionTest likeAuction = new LikeAuctionTest();
					likeAuction.chooseTest(selectMode);
					break;
			case "28":
					System.out.println("Run a test (0 for all)");
					selectMode = this.select();
					GetListLikesTest listLikes = new GetListLikesTest();
					listLikes.chooseTest(selectMode);
					break;
			case "29":
					System.out.println("Run a test (0 for all)");
					selectMode = this.select();
					TotalLikeOfAuctionTest totalLike = new TotalLikeOfAuctionTest();
					totalLike.chooseTest(selectMode);
					break;
			case "30":
					System.out.println("Run a test (0 for all)");
					selectMode = this.select();
					GetNewsTest getNews = new GetNewsTest();
					getNews.chooseTest(selectMode);
					break;
			case "31":
					System.out.println("Run a test (0 for all)");
					selectMode = this.select();
					ReadNewTest readNew = new ReadNewTest();
					readNew.chooseTest(selectMode);
					break;
			case "32":
					System.out.println("Run a test (0 for all)");
					selectMode = this.select();
					GetNotificationsTest getNoti = new GetNotificationsTest();
					getNoti.chooseTest(selectMode);
					break;
			case "33":
					System.out.println("Run a test (0 for all)");
					selectMode = this.select();
					ReadNotificationsTest readNoti = new ReadNotificationsTest();
					readNoti.chooseTest(selectMode);
					break;
			case "34":
					System.out.println("Run a test (0 for all)");
					selectMode = this.select();
					GetSliderTest getSlider = new GetSliderTest();
					getSlider.chooseTest(selectMode);
					break;
			case "35":
					System.out.println("Run a test (0 for all)");
					selectMode = this.select();
					SearchTest search = new SearchTest();
					search.chooseTest(selectMode);
					break;
			case "36":
					System.out.println("Run a test (0 for all)");
					selectMode = this.select();
					DeleteNotificationTest del = new DeleteNotificationTest();
					del.chooseTest(selectMode);
					break;
			case "37":
					System.out.println("Run a test (0 for all)");
					selectMode = this.select();
					GetListChatTest listChat = new GetListChatTest();
					listChat.chooseTest(selectMode);
					break;
			case "41":
					System.out.println("Run a test (0 for all)");
					selectMode = this.select();
					DeliveryTest delivery = new DeliveryTest();
					delivery.chooseTest(selectMode);
					break;
			case "42":
				selectMode = this.select();
				
				LoginTest loginTest1 = new LoginTest();
				loginTest1.chooseTest(selectMode);
				
				SignupTest signup1 = new SignupTest();
				signup1.chooseTest(selectMode);
				
				EditAccountTest edit1 = new EditAccountTest();
				edit1.chooseTest(selectMode);
				
				LogoutTest logoutTest1 = new LogoutTest();
				logoutTest1.chooseTest(selectMode);

				ChangePassTest change1 = new ChangePassTest();
				change1.chooseTest(selectMode);
				
				InfoTest info1 = new InfoTest();
				info1.chooseTest(selectMode);

				GetListAuctionsTest listAuctions1 = new GetListAuctionsTest();
				listAuctions1.chooseTest(selectMode);

				GetDetailAuctionsTest detailAuctions1 = new GetDetailAuctionsTest();
				detailAuctions1.chooseTest(selectMode);

				CreateAuctionTest creAuctions1 = new CreateAuctionTest();
				creAuctions1.chooseTest(selectMode);

				EditAuctionTest editAuctions1 = new EditAuctionTest();
				editAuctions1.chooseTest(selectMode);

				DeleteAuctionTest delAuction1 = new DeleteAuctionTest();
				delAuction1.chooseTest(selectMode);		

				InfoAuctionTest infoAuction1 = new InfoAuctionTest();
				infoAuction1.chooseTest(selectMode);
				
				CreateItemTest creItem1 = new CreateItemTest();
				creItem1.chooseTest(selectMode);

				InfoItemTest infoItem1 = new InfoItemTest();
				infoItem1.chooseTest(selectMode);

				CreateCommentTest creCmt1 = new CreateCommentTest();
				creCmt1.chooseTest(selectMode);

				GetListCommentsTest listCmt1 = new GetListCommentsTest();
				listCmt1.chooseTest(selectMode);

//				CreateBidTest creBid1 = new CreateBidTest();
//				creBid1.chooseTest(selectMode);

				GetListBidsTest listbid1 = new GetListBidsTest();
				listbid1.chooseTest(selectMode);

				GetListCategoriesTest listCate1 = new GetListCategoriesTest();
				listCate1.chooseTest(selectMode);

				GetListBrandsTest listBrands1 = new GetListBrandsTest();
				listBrands1.chooseTest(selectMode);

				LikeAuctionTest likeAuction1 = new LikeAuctionTest();
				likeAuction1.chooseTest(selectMode);

				GetListLikesTest listLikes1 = new GetListLikesTest();
				listLikes1.chooseTest(selectMode);

				TotalLikeOfAuctionTest totalLike1 = new TotalLikeOfAuctionTest();
				totalLike1.chooseTest(selectMode);

				GetNewsTest getNews1 = new GetNewsTest();
				getNews1.chooseTest(selectMode);

				ReadNewTest readNew1 = new ReadNewTest();
				readNew1.chooseTest(selectMode);
	
				GetNotificationsTest getNoti1 = new GetNotificationsTest();
				getNoti1.chooseTest(selectMode);

				ReadNotificationsTest readNoti1 = new ReadNotificationsTest();
				readNoti1.chooseTest(selectMode);

				GetSliderTest getSlider1 = new GetSliderTest();
				getSlider1.chooseTest(selectMode);
	
				SearchTest search1 = new SearchTest();
				search1.chooseTest(selectMode);

				DeleteNotificationTest del1 = new DeleteNotificationTest();
				del1.chooseTest(selectMode);

				GetListChatTest listChat1 = new GetListChatTest();
				listChat1.chooseTest(selectMode);

				DeliveryTest delivery1 = new DeliveryTest();
				delivery1.chooseTest(selectMode);
				break;
					
						
			}
	}
}