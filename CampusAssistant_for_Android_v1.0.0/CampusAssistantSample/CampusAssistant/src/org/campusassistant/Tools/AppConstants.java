package org.campusassistant.Tools;

public class AppConstants {
	/**
	 * 调试接口用的测试数据
	 */
	// ===============================课程表API===============================//
	// 【模拟】网络课程表协议
	public static final String DEBUG_PROTOCOL_CURRICULUM = "{\"status\":\"OK\",\"response\":{\"college\":\"天津大学\",\"institute\":\"电子信息工程学院\",\"major\":\"电子信息工程\",\"class\":\"3\",\"grade\":\"2011\",\"semester\":\"12132\",\"curriculum\":[[[{\"courseId\":\"\",\"courseName\":\"\",\"type\":\"\"}],[{\"courseId\":\"\",\"courseName\":\"\",\"type\":\"\"}],[{\"courseId\":\"\",\"courseName\":\"\",\"type\":\"\"}],[{\"courseId\":\"\",\"courseName\":\"\",\"type\":\"\"}],[{\"courseId\":\"\",\"courseName\":\"\",\"type\":\"\"}],[{\"courseId\":\"\",\"courseName\":\"\",\"type\":\"\"}],[{\"courseId\":\"\",\"courseName\":\"\",\"type\":\"\"}],[{\"courseId\":\"\",\"courseName\":\"\",\"type\":\"\"}]],[[{\"courseId\":\"0001\",\"courseName\":\"电磁场与电磁波\",\"type\":\"1\"}],[{\"courseId\":\"\",\"courseName\":\"\",\"type\":\"\"}],[{\"courseId\":\"0002\",\"courseName\":\"数字逻辑电路\",\"type\":\"1\"}],[{\"courseId\":\"\",\"courseName\":\"\",\"type\":\"\"}],[{\"courseId\":\"\",\"courseName\":\"\",\"type\":\"\"}],[{\"courseId\":\"\",\"courseName\":\"\",\"type\":\"\"}],[{\"courseId\":\"\",\"courseName\":\"\",\"type\":\"\"}],[{\"courseId\":\"\",\"courseName\":\"\",\"type\":\"\"}]],[[{\"courseId\":\"0003\",\"courseName\":\"概率论与数理统计1\",\"type\":\"1\"}],[{\"courseId\":\"0004\",\"courseName\":\"高频电子线路\",\"type\":\"1\"}],[{\"courseId\":\"\",\"courseName\":\"\",\"type\":\"\"}],[{\"courseId\":\"\",\"courseName\":\"\",\"type\":\"\"}],[{\"courseId\":\"\",\"courseName\":\"\",\"type\":\"\"}],[{\"courseId\":\"\",\"courseName\":\"\",\"type\":\"\"}],[{\"courseId\":\"\",\"courseName\":\"\",\"type\":\"\"}],[{\"courseId\":\"\",\"courseName\":\"\",\"type\":\"\"}]],[[{\"courseId\":\"0001\",\"courseName\":\"电磁场与电磁波\",\"type\":\"1\"}],[{\"courseId\":\"0005\",\"courseName\":\"英语读写译1D\",\"type\":\"2\"},{\"courseId\":\"0005\",\"courseName\":\"英语读写译1D\",\"type\":\"2\"},{\"courseId\":\"0005\",\"courseName\":\"英语读写译1D\",\"type\":\"2\"},{\"courseId\":\"0005\",\"courseName\":\"英语读写译1D\",\"type\":\"2\"},{\"courseId\":\"0005\",\"courseName\":\"英语读写译1D\",\"type\":\"2\"}],[{\"courseId\":\"0006\",\"courseName\":\"物理实验\",\"type\":\"1\"}],[{\"courseId\":\"\",\"courseName\":\"\",\"type\":\"\"}],[{\"courseId\":\"0007\",\"courseName\":\"数理方程\",\"type\":\"2\"}],[{\"courseId\":\"\",\"courseName\":\"\",\"type\":\"\"}],[{\"courseId\":\"\",\"courseName\":\"\",\"type\":\"\"}],[{\"courseId\":\"\",\"courseName\":\"\",\"type\":\"\"}]],[[{\"courseId\":\"0002\",\"courseName\":\"数字逻辑电路\",\"type\":\"1\"}],[{\"courseId\":\"0004\",\"courseName\":\"高频电子线路\",\"type\":\"1\"}],[{\"courseId\":\"0003\",\"courseName\":\"概率论与数理统计1\",\"type\":\"1\"}],[{\"courseId\":\"\",\"courseName\":\"\",\"type\":\"\"}],[{\"courseId\":\"\",\"courseName\":\"\",\"type\":\"\"}],[{\"courseId\":\"\",\"courseName\":\"\",\"type\":\"\"}],[{\"courseId\":\"\",\"courseName\":\"\",\"type\":\"\"}],[{\"courseId\":\"\",\"courseName\":\"\",\"type\":\"\"}]],[[{\"courseId\":\"\",\"courseName\":\"\",\"type\":\"\"}],[{\"courseId\":\"0008\",\"courseName\":\"体育D\",\"type\":\"3\"}],[{\"courseId\":\"\",\"courseName\":\"\",\"type\":\"\"}],[{\"courseId\":\"\",\"courseName\":\"\",\"type\":\"\"}],[{\"courseId\":\"\",\"courseName\":\"\",\"type\":\"\"}],[{\"courseId\":\"\",\"courseName\":\"\",\"type\":\"\"}],[{\"courseId\":\"\",\"courseName \":\"\",\"type\":\"\"}],[{\"courseId\":\"\",\"courseName\":\"\",\"type\":\"\"}]],[[{\"courseId\":\"\",\"courseName\":\"\",\"type\":\"\"}],[{\"courseId\":\"\",\"courseName\":\"\",\"type\":\"\"}],[{\"courseId\":\"\",\"courseName\":\"\",\"type\":\"\"}],[{\"courseId\":\"\",\"courseName\":\"\",\"type\":\"\"}],[{\"courseId\":\"\",\"courseName\":\"\",\"type\":\"\"}],[{\"courseId\":\"\",\"courseName\":\"\",\"type\":\"\"}],[{\"courseId\":\"\",\"courseName\":\"\",\"type\":\"\"}],[{\"courseId\":\"\",\"courseName\":\"\",\"type\":\"\"}]]]}}";

	// 【模拟】课程详细信息协议
	public static final String DEBUG_PROTOCOL_COURSE = "{\"status\":\"OK\",\"command\":\"getcourse\",\"response\":[{\"id\":\"0001\",\"name\":\"电磁场与电磁波\",\"desc\":\"2011 电子信息工程3班;教学环节:第1-16周[理论教学],第17-18周[考试]备注:学校统一安排16学时的“形势与政策”课，具体上课事宜由学工部德育教研室通知\",\"type\":\"1\",\"teachers\":[{\"teacherId\":\"0001\",\"teacherName\":\"张瑞峰\"}],\"classrooms\":[{\"classroomId\":\"0001\",\"classroomName\":\"23楼202\"}],\"interval\":\"0\",\"startWeek\":\"1\",\"endWeek\":\"16\",\"credit\":\"3\"},{\"id\":\"0002\",\"name\":\"数字逻辑电路\",\"desc\":\"2011 电子信息工程3班;教学环节:第1-16周[理论教学],第17-18周[考试]备注:学校统一安排16学时的“形势与政策”课，具体上课事宜由学工部德育教研室通知。\",\"type\":\"1\",\"teachers\":[{\"teacherId\":\"0002\",\"teacherName\":\"于洁潇\"}],\"classrooms\":[{\"classroomId\":\"0002\",\"classroomName\":\"24楼402\"}],\"interval\":\"0\",\"startWeek\":\"1\",\"endWeek\":\"16\",\"credit\":\"4\"}]}";
	// 【模拟】教室信息协议
	public static final String DEBUG_PROTOCOL_CLASSROOM = "{\"status\":\"OK\",\"command\":\"getclassroom\",\"response\":{\"id\":\"0001\",\"name\":\"阶梯教室101\",\"address\":\"清华大学东校区2号阶梯楼101室\",\"position\":{\"longitude\":\"116.40\",\"latitude\":\"39.60\"},\"open_info\":[{\"weekday\":\"0\",\"status\":\"closed\"},{\"weekday\":\"1\",\"status\":\"open\",\"start_time\":\"07:30\",\"end_time\":\"22:30\"},{\"weekday\":\"2\",\"status\":\"open\",\"start_time\":\"07:30\",\"end_time\":\"22:30\"},{\"weekday\":\"3\",\"status\":\"open\",\"start_time\":\"07:30\",\"end_time\":\"22:30\"},{\"weekday\":\"4\",\"status\":\"open\",\"start_time\":\"07:30\",\"end_time\":\"22:30\"},{\"weekday\":\"5\",\"status\":\"open\",\"start_time\":\"07:30\",\"end_time\":\"22:30\"},{\"weekday\":\"6\",\"status\":\"closed\"}]}}";

	// ===============================资讯API===============================//
	// 【模拟】获取资讯类别列表协议
	public static final String DEBUG_PROTOCOL_NEWSCATEGORY = "{\"status\":\"OK\",\"cmd\":\"getnewscategory\",\"response\":[{\"id\":\"0001\",\"title\":\"校园热点\",\"tag\":\"资讯 院校 生活 全体\",\"desc\":\"校园热点，最新的校园信息。\",\"icon\":\"http://a.hiphotos.baidu.com/album/w%3D2048/sign=40a404d430adcbef0134790698972edd/3b292df5e0fe99252c37544035a85edf8db171e2.jpg\"},{\"id\":\"0002\",\"title\":\"失物招领\",\"tag\":\"资讯 院校 生活 学生\",\"desc\":\"只有你没丢的，没有你丢了找不到的。\",\"icon\":\"http://f.hiphotos.baidu.com/album/w%3D2048/sign=ed3657d430adcbef0134790698972fdd/3b292df5e0fe992581a5074035a85edf8db17170.jpg\"}]}";
	// 【模拟】获取某列别的资讯列表协议
	public static final String DEBUG_PROTOCOL_NEWSLIST = "{\"status\":\"OK\",\"cmd\":\"getnewslist\",\"response\":[{\"id\":\"0001\",\"title\":\"欢迎新生\",\"brief\":\"又是一年秋风爽，还看今年新生靓\",\"date_time\":\"2013-09-10 10:15\",\"author\":\"Carl\",\"tag\":\"资讯 新闻 院校 学生\",\"type\":\"text\",\"small_icon\":\"http://d.hiphotos.baidu.com/album/w%3D2048/sign=0d2875910e2442a7ae0efaa5e57bac4b/f9198618367adab4d99454518ad4b31c8701e458.jpg\",\"big_image\":\"http://a.hiphotos.baidu.com/album/w%3D2048/sign=522a190563d0f703e6b292dc3cc2503d/6159252dd42a2834eca279195ab5c9ea15cebf98.jpg\",\"content_url\":\"http://mobile.163.com/13/0510/06/8UGC82TK00112K8E.html\"},{\"id\":\"0001\",\"title\":\"欢迎新生\",\"brief\":\"又是一年秋风爽，还看今年新生靓\",\"date_time\":\"2013-09-10 10:15\",\"author\":\"Carl\",\"tag\":\"资讯 新闻 院校 学生\",\"type\":\"text\",\"small_icon\":\"http://d.hiphotos.baidu.com/album/w%3D2048/sign=0d2875910e2442a7ae0efaa5e57bac4b/f9198618367adab4d99454518ad4b31c8701e458.jpg\",\"big_image\":\"http://a.hiphotos.baidu.com/album/w%3D2048/sign=522a190563d0f703e6b292dc3cc2503d/6159252dd42a2834eca279195ab5c9ea15cebf98.jpg\",\"content_url\":\"http://mobile.163.com/13/0510/06/8UGC82TK00112K8E.html\"},{\"id\":\"0001\",\"title\":\"欢迎新生\",\"brief\":\"又是一年秋风爽，还看今年新生靓\",\"date_time\":\"2013-09-10 10:15\",\"author\":\"Carl\",\"tag\":\"资讯 新闻 院校 学生\",\"type\":\"text\",\"small_icon\":\"http://d.hiphotos.baidu.com/album/w%3D2048/sign=0d2875910e2442a7ae0efaa5e57bac4b/f9198618367adab4d99454518ad4b31c8701e458.jpg\",\"big_image\":\"http://a.hiphotos.baidu.com/album/w%3D2048/sign=522a190563d0f703e6b292dc3cc2503d/6159252dd42a2834eca279195ab5c9ea15cebf98.jpg\",\"content_url\":\"http://mobile.163.com/13/0510/06/8UGC82TK00112K8E.html\"},{\"id\":\"0001\",\"title\":\"欢迎新生\",\"brief\":\"又是一年秋风爽，还看今年新生靓\",\"date_time\":\"2013-09-10 10:15\",\"author\":\"Carl\",\"tag\":\"资讯 新闻 院校 学生\",\"type\":\"text\",\"small_icon\":\"http://d.hiphotos.baidu.com/album/w%3D2048/sign=0d2875910e2442a7ae0efaa5e57bac4b/f9198618367adab4d99454518ad4b31c8701e458.jpg\",\"big_image\":\"http://a.hiphotos.baidu.com/album/w%3D2048/sign=522a190563d0f703e6b292dc3cc2503d/6159252dd42a2834eca279195ab5c9ea15cebf98.jpg\",\"content_url\":\"http://mobile.163.com/13/0510/06/8UGC82TK00112K8E.html\"},{\"id\":\"0001\",\"title\":\"欢迎新生\",\"brief\":\"又是一年秋风爽，还看今年新生靓\",\"date_time\":\"2013-09-10 10:15\",\"author\":\"Carl\",\"tag\":\"资讯 新闻 院校 学生\",\"type\":\"text\",\"small_icon\":\"http://d.hiphotos.baidu.com/album/w%3D2048/sign=0d2875910e2442a7ae0efaa5e57bac4b/f9198618367adab4d99454518ad4b31c8701e458.jpg\",\"big_image\":\"http://a.hiphotos.baidu.com/album/w%3D2048/sign=522a190563d0f703e6b292dc3cc2503d/6159252dd42a2834eca279195ab5c9ea15cebf98.jpg\",\"content_url\":\"http://mobile.163.com/13/0510/06/8UGC82TK00112K8E.html\"}],\"max_page\":\"10\",\"current_page\":\"1\"}";
	// 【模拟】获取失物招领列表协议
	public static final String DEBUG_PROTOCOL_NEWSLIST_LOST = "{\"status\":\"OK\",\"cmd\":\"getnewslist\",\"response\":[{\"id\":\"0001\",\"title\":\"iphone5丢失\",\"brief\":\"今天丢的第二个手机了。\",\"date_time\":\"2013-09-10 10:15\",\"author\":\"Carl\",\"tag\":\"资讯 新闻 院校 学生\",\"type\":\"text\",\"small_icon\":\"http://d.hiphotos.baidu.com/album/w%3D2048/sign=0d2875910e2442a7ae0efaa5e57bac4b/f9198618367adab4d99454518ad4b31c8701e458.jpg\",\"big_image\":\"http://a.hiphotos.baidu.com/album/w%3D2048/sign=522a190563d0f703e6b292dc3cc2503d/6159252dd42a2834eca279195ab5c9ea15cebf98.jpg\",\"content_url\":\"http://mobile.163.com/13/0510/06/8UGC82TK00112K8E.html\"},{\"id\":\"0001\",\"title\":\"macbook pro 15寸，丢在图书馆了\",\"brief\":\"好心人捡到，必有重谢！！\",\"date_time\":\"2013-09-10 10:15\",\"author\":\"Carl\",\"tag\":\"资讯 新闻 院校 学生\",\"type\":\"text\",\"small_icon\":\"http://d.hiphotos.baidu.com/album/w%3D2048/sign=0d2875910e2442a7ae0efaa5e57bac4b/f9198618367adab4d99454518ad4b31c8701e458.jpg\",\"big_image\":\"http://a.hiphotos.baidu.com/album/w%3D2048/sign=522a190563d0f703e6b292dc3cc2503d/6159252dd42a2834eca279195ab5c9ea15cebf98.jpg\",\"content_url\":\"http://mobile.163.com/13/0510/06/8UGC82TK00112K8E.html\"}],\"max_page\":\"10\",\"current_page\":\"1\"}";

	public static final String DEBUG_PROTOCOL_CAMPUS = "{\"status\":\"OK\",\"cmd\":\"getcampus\",\"response\":[{\"id\":\"001\",\"name\":\"东校区\"},{\"id\":\"002\",\"name\":\"西校区\"},{\"id\":\"003\",\"name\":\"北校区\"}]}";
	public static final String DEBUG_PROTOCOL_CAMPUSBUILDING = "{\"status\":\"OK\",\"cmd\":\"getcampusbuilding\",\"response\":[{\"id\":\"0001\",\"campus_id\":\"001\",\"name\":\"明湖\",\"brief\":\"好地方\",\"content_url\":\"http://www.njtu.edu.cn/\"},{\"id\":\"0002\",\"campus_id\":\"002\",\"name\":\"图书馆\",\"brief\":\"好地方\",\"content_url\":\"http://www.njtu.edu.cn/\"},{\"id\":\"0003\",\"campus_id\":\"003\",\"name\":\"逸夫楼\",\"brief\":\"好地方\",\"content_url\":\"http://www.njtu.edu.cn/\"}]}";
	
	// 数据库的名称
	public static final String DB_NAME = "BaiduCurriculumDao.db";
	// 数据库版本号
	public static final int DB_VERSION = 1;
	static String userToken = "";
	/**
	 * 百度开发者账号系统
	 */
	/** Get the access token of developer. */
	public static String getDeveloperAccessToken() {
//			 return "Access token of developer";
		return "3.68583fb90b6dfa1b3d706bdb1f49b180.2592000.1371867771.1779169447-877227";
	}
	
	public static void setUserAccessToken(String token){
		userToken = token;
	}
	/** Get the access token of user. */
	public static String getUserAccessToken() {
		 return userToken;
	}

}
