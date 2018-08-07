/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50610
Source Host           : localhost:3306
Source Database       : basicframe

Target Server Type    : MYSQL
Target Server Version : 50610
File Encoding         : 65001

Date: 2018-08-07 14:22:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for f_anser
-- ----------------------------
DROP TABLE IF EXISTS `f_anser`;
CREATE TABLE `f_anser` (
  `key` varchar(16) NOT NULL,
  `value` text,
  PRIMARY KEY (`key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of f_anser
-- ----------------------------
INSERT INTO `f_anser` VALUES ('CIE', '适合的典型专业有：会计学、印刷工程等。</br>适合的典型职业有：记录员、打字员、统计员、支票记录员、订货员、校对员、办公室工作人员。');
INSERT INTO `f_anser` VALUES ('CIR', '适合的典型专业有：档案学、安全工程、印刷工程等。</br>适合的典型职业有：记录员、校对员、工程职员、海底电报员、检修计划员、发扳员。');
INSERT INTO `f_anser` VALUES ('CIS', '适合的典型专业有：金融学、档案学、安全工程等。</br>适合的典型职业有：记账员、顾客服务员、报刊发行员、土地测量员、保险公司职员、会计师、估价员、邮政检查员、外贸检查员。');
INSERT INTO `f_anser` VALUES ('CRE', '适合的典型专业有：印刷工程、商务信息管理等。</br>适合的典型职业有：标价员、实验室工作者、广告管理员、自动打字机操作员、电动机装配工、缝纫机操作工、空中交通控制员。');
INSERT INTO `f_anser` VALUES ('CRI', '适合的典型专业有：印刷工程、财务管理、临床医学、档案学等。</br>适合的典型职业有：商务程序员、簿记员、会计、记时员、铸造机操作工、打字员、按键操作工、复印机操作工。');
INSERT INTO `f_anser` VALUES ('CRS', '适合的典型专业有：财务管理、临床医学、档案学、图书馆学、会计学等。</br>适合的典型职业有：会计、仓库保管员、档案管理员、缝纫工、讲述员、收款人。');
INSERT INTO `f_anser` VALUES ('IAR', '适合的典型专业有：纺织工程、园林工程、建筑设计、考古学、地质工程。</br>适合的典型职业有：人类学家、天丈学家、化学家、物理学家、医学病理、动物标本剥制者、化石修复者、艺术品管理者。');
INSERT INTO `f_anser` VALUES ('IAS', '适合的典型专业有：汉语言文学、工业设计、建筑设计、城市规划、环境工程。</br>适合的典型职业有：普通经济学家、农场经济学家、财政经济学家、国际贸易经济学家、实验心理学家、工程心理学家、心理学家、哲学家、内科医生、数学家。');
INSERT INTO `f_anser` VALUES ('ICR', '适合的典型专业有：药学、制药工程、交通工程、地质学、地球物理学、大气科学、中医学、基础医学、自动化、水文与水资源工程、统计学等。</br>适合的典型职业有：质量检验技术员、药剂师、物理学家、地质学技师、环境工程师、法官、图书馆技术辅导员、计算机科学家、医院听诊员、家禽检查员、水利工程师、理疗师、中医师、公共卫生医师、医疗顾问。');
INSERT INTO `f_anser` VALUES ('IEC', '适合的典型专业有：水利水电工程、计算机科学、软件工程、财政学、财务管理、应用数学。</br>适合的典型职业有：计算机科学家、软件工程师、档案保管员、保险统计员、证券分析师、财务主管。');
INSERT INTO `f_anser` VALUES ('IES', '适合的典型专业有：水利水电工程、经济学、资源环境与城乡规划管理、水利水电工程等。</br>适合的典型职业有：细菌学家、生理学家、化学专家、地质专家、地理物理学专家、纺织技术专家、医院药剂师、工业药剂师、药房营业员。');
INSERT INTO `f_anser` VALUES ('IRA', '适合的典型专业有：纺织工程、冶金工程、金属材料工程、生物医学工程、测绘工程、法医学。</br>适合的典型职业有：地理学家、地质学家、声学物理学家、矿物学家、古生物学家、石油学家、地震学家、声学物理学家、原子和分子物理学家、电学和磁学物理学家、气象学家、设计审核员、人口统计学家、数学统计学家、外科医生、城市规划家、气象员。');
INSERT INTO `f_anser` VALUES ('IRC', '适合的典型专业有：管理科学、冶金工程、金属材料工程、无机非金属材料工程、高分子材料与工程、材料成型及控制工程、过程装备与控制工程、热能与动力工程、电气工程及其自动化、通信工程、计算机科学与技术、生物医学工程、测绘工程、制药工程、交通工程、信息与计算科学、物理学、生物科学类、地质学、地球物理学、大气科学类、理论与应用力学、材料化学、中医学、交通运输。</br>适合的典型职业有：飞机领航员、飞行员、物理实验室技师、文献检查员、农业技术专家、动植物技术专家、生物技师、油管检查员、工商业规划者、矿藏安全检查员、纺织品检验员、照相机修理者、工程技术员、编计算程序者、工具设计者、仪器维修工。');
INSERT INTO `f_anser` VALUES ('IRE', '适合的典型专业有：经济学、材料成型及控制工程、电气工程及其自动化、物理学、化学、生物科学、生物化学、材料化学、微电子学、轻化工程、采矿工程、民用工程、地理学、地质学、数学、计算机科学、统计学、人种学、考古学、环境科学、农业工程、计算机工程、电子工程、机械工程、建筑学等。</br>适合的典型职业有：化学家、化验员、化学工程师、纺织工程师、食品技师、渔业技术专家、材料和测试工程师、电气工程师、土木工程师、航空工程师、行政官员、冶金专家、原子核工程师、陶瓷工程师、地质工程师、电力工程量、口腔科医生、牙科医生、公共卫生医师、制图员、测绘师。');
INSERT INTO `f_anser` VALUES ('IRS', '适合的典型专业有：动物科学、药学、牙科学、经济学、管理科学、冶金工程、金属材料工程、热能与动力工程、电气工程及其自动化、计算机科学与技术、交通工程、地质学、材料化学、中医学、农业资源与环境、交通运输、应用物理学等。</br>适合的典型职业有：流体物理学家、物理海洋学家、等离子体物理学家、农业科学家、动物学家、食品科学家、园艺学家、植物学家、细菌学家、解剖学家、动物病理学家、作物病理学家、药物学家、生物化学家、生物物理学家、细胞生物学家、临床化学家、遗传学家、分子生物学家、质量控制工程师、地理学家、兽医、放射性治疗技师。');
INSERT INTO `f_anser` VALUES ('ISA', '适合的典型专业有：汉语言文学、环境科学、护理学、医疗器械工程、工业心理学、管理心理学等。</br>适合的典型职业有：实验心理学家、普通心理学家、发展心理学家、教育心理学家、社会心理学家、临床心理学家、目标学家、皮肤病学家、精神病学家、妇产科医师、眼科医生、五官科医生、医学实验室技术专家、民航医务人员、护士、医疗器械工程师、工作分析工程师。');
INSERT INTO `f_anser` VALUES ('ISC', '适合的典型专业有：汉语言文学、药学、教育学、哲学、国际经济与贸易、社会学、政治学与行政学、地理科学、环境科学等。</br>适合的典型职业有：侦察员、电视播音室修理员、电视修理服务员、验尸室人员、编目录者、医学实验定技师、调查研究者。');
INSERT INTO `f_anser` VALUES ('ISE', '适合的典型专业有：资源环境与城乡规划管理、经济学、国际经济与贸易、社会学、地理学、环境科学。</br>适合的典型职业有：营养学家、饮食顾问、火灾检查员、邮政服务检查员。');
INSERT INTO `f_anser` VALUES ('ISR', '适合的典型专业有：生物学、药学、经济学、交通工程、地质学、中医学、应用物理学等。</br>适合的典型职业有：生物学家、水生生物学者，昆虫学者、微生物学家、配镜师、矫正视力者、细菌学家、牙科医生、骨科医生。');
INSERT INTO `f_anser` VALUES ('RAI', '适合的典型专业有：园艺、音乐学、美术学、艺术设计、纺织工程。</br>适合的典型职业有：手工雕刻、玻璃雕刻、制作模型人员、家具木工、制作皮革品、手工绣花、手工钩针纺织、排字工作、印刷工作、图画雕刻、装订工。');
INSERT INTO `f_anser` VALUES ('RCE', '适合的典型专业有：勘查技术与工程、油气储运工程、航海技术、工程管理、测绘工程、建筑工程、机械工程等。</br>适合的典型职业有：建筑师、机械师、测绘师、打井工、吊车驾驶员、农场工人、邮件分类员、铲车司机、拖拉机司机。');
INSERT INTO `f_anser` VALUES ('RCI', '适合的典型专业有：临床医学、建筑学、麻醉学、医学影像学、农学、教育技术学、勘查技术与工程、建筑环境与设备工程、动物医学、土木工程、环境工程、油气储运工程、航海技术、地理信息系统、港口航道与海岸工程。</br>适合的典型职业有：测量员、勘测员、仪表操作者、农业工程技术、化学工程技师、民用工程技师、石油工程技师、资料室管理员、探矿工、煅烧工、烧窖工、矿工、保养工、磨床工、取样工、样品检验员、纺纱工、炮手、漂洗工、电焊工、锯木工、刨床工、制帽工、手工缝纫工、油漆工、染色工、按摩工、木匠、农民建筑工作、电影放映员、勘测员助手。');
INSERT INTO `f_anser` VALUES ('RCS', '适合的典型专业有：临床医学、建筑学、勘查技术与工程、建筑环境与设备工程、环境工程、油气储运工程、航海技术、港口航道与海岸工程、给排水工程。</br>适合的典型职业有：公共汽车驾驶员、一等水手、游泳池服务员、裁缝、建筑工作、石匠、烟囱修建工、混凝土工、电话修理工、爆炸手、邮递员、矿工、裱糊工人、纺纱工。');
INSERT INTO `f_anser` VALUES ('REC', '适合的典型专业有：油气储运工程、物业管理、物流、工程管理、交通管理等。</br>适合的典型职业有：抄水表员、保姆、实验员、动物饲养员、动物管理员。');
INSERT INTO `f_anser` VALUES ('REI', '适合的典型专业有：油气储运工程、动物科学、农林牧渔业经营、航运管理等。</br>适合的典型职业有：轮船船长、航海领航员、大副、试管实验员。');
INSERT INTO `f_anser` VALUES ('RES', '适合的典型专业有：油气储运工程、动物科学、物流管理、旅游管理、海事、农业机械、建筑施工、体育。</br>适合的典型职业有：旅馆服务员、家畜饲养员、渔民、渔网修补工、水手长、收割机操作工、搬运行李工人、公园服务员、救生员、登山导游、火车工程技术员、建筑工作、铺轨工人。');
INSERT INTO `f_anser` VALUES ('RIA', '适合的典型专业有：冶金工程、纺织工程、金属材料工程、船舶与海洋工程、海洋技术、林学。</br>适合的典型职业有：牙科技术员、陶工、建筑设计员、模型工、细木工、制作链条人员。');
INSERT INTO `f_anser` VALUES ('RIC', '适合的典型专业有：信息管理与信息系统、冶金工程、金属材料工程、过程装备与控制工程、热能与动力工程、电气工程及其自动化、通信工程、计算机科学与技术、交通运输、教育技术学、植物保护学、动物医学、机械设计制造及其自动化、测控技术与仪器、土木工程、环境工程、油气储运工程、船舶与海洋工程、轻化工程、化学类、地理信息系统、海洋技术、医学检验、法医学、港口航道与海岸工程。</br>适合的典型职业有：船上工作人员、接待员、杂志保管员、牙医助手、制帽工、磨坊工、石匠、机器制造、机车(火车头)制造、农业机器装配、汽车装配工、缝纫机装配工、钟表装配和检验、电动器具装配、鞋匠、锁匠、货物检验员、电梯机修工、托儿所所长、钢琴调音员、装配工、印刷工、建筑钢铁工作、卡车司机。');
INSERT INTO `f_anser` VALUES ('RIE ', '适合的典型专业有：冶金工程、金属材料工程、电气工程及其自动化、测控技术与仪器、油气储运工程、船舶与海洋工程、轻化工程、海洋技术、采矿工程、动物科学。</br>适合的典型职业有：建筑和桥梁工程、环境工程、航空工程、公路工程、电力工程、信号工程、电话工程、一般机械工程、自动工程、矿业工程、海洋工程、交通工程技术人员、制图员、家政经济人员、计量员、农民、农场工人、农业机械操作、清洁工、无线电修理、汽车修理、手表修理、管工、线路装配工、工具仓库管理员。');
INSERT INTO `f_anser` VALUES ('RIS', '适合的典型专业有：冶金工程、金属材料工程、热能与动力工程、电气工程及其自动化、计算机科学与技术、交通运输、环境工程、油气储运工程、海洋技术、医学检验、针灸推拿学、法医学、林学、动物科学、港口航道与海岸工程、化学工程与工艺、电子信息科学与技术。</br>适合的典型职业有：厨师、林务员、跳水员、潜水员、染色员、电器修理、眼镜制作、电工、纺织机器装配工、服务员、装玻璃工人、发电厂工人、焊接工、各业工程师。');
INSERT INTO `f_anser` VALUES ('RSE', '适合的典型专业有：油气储运工程、动物科学、体育学类、广播电视编导。</br>适合的典型职业有：消防员、交通巡警、警察、门卫、理发师、房间清洁工、屠夫、锻工、开凿工人、管道安装工、出租汽车驾驶员、货物搬运工、送报员、勘探员、娱乐场所的服务员、起卸机操作工、灭害虫者、电梯操作工、厨房助手。');
INSERT INTO `f_anser` VALUES ('RSI', '适合的典型专业有：环境工程、油气储运工程、针灸推拿学、动物科学、港口航道与海岸工程、城市规划。</br>适合的典型职业有：纺织工、编织工、农业学校教师、某些职业课程教师(诸如艺术、商业、技术、工艺课程)、雨衣上胶工。');

-- ----------------------------
-- Table structure for f_subject
-- ----------------------------
DROP TABLE IF EXISTS `f_subject`;
CREATE TABLE `f_subject` (
  `id` int(8) NOT NULL,
  `title` varchar(512) DEFAULT NULL,
  `type` int(8) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of f_subject
-- ----------------------------
INSERT INTO `f_subject` VALUES ('1', '装配修理电器或玩具。', '1');
INSERT INTO `f_subject` VALUES ('2', '修理自行车。', '1');
INSERT INTO `f_subject` VALUES ('3', '用木头做东西。', '1');
INSERT INTO `f_subject` VALUES ('4', '开汽车或摩托车。', '1');
INSERT INTO `f_subject` VALUES ('5', '用机器做东西。', '1');
INSERT INTO `f_subject` VALUES ('6', '参加木工技术学习班。', '1');
INSERT INTO `f_subject` VALUES ('7', '参加制图描图学习班。', '1');
INSERT INTO `f_subject` VALUES ('8', ' 驾驶卡车或拖拉机。', '1');
INSERT INTO `f_subject` VALUES ('9', '参加机械和电气学习。', '1');
INSERT INTO `f_subject` VALUES ('10', '装配修理电器。', '1');
INSERT INTO `f_subject` VALUES ('11', '素描、制图或绘画。', '1');
INSERT INTO `f_subject` VALUES ('12', '参加话剧戏曲。', '1');
INSERT INTO `f_subject` VALUES ('13', '设计家具布置室内。', '1');
INSERT INTO `f_subject` VALUES ('14', '练习乐器、参加乐队。', '1');
INSERT INTO `f_subject` VALUES ('15', '欣赏音乐或戏剧。', '1');
INSERT INTO `f_subject` VALUES ('16', '看小说、读剧本。', '1');
INSERT INTO `f_subject` VALUES ('17', '从事摄影创作。', '1');
INSERT INTO `f_subject` VALUES ('18', '写诗或吟诗。', '1');
INSERT INTO `f_subject` VALUES ('19', '进艺术(美/音)培训班。', '1');
INSERT INTO `f_subject` VALUES ('20', '练习书法。', '1');
INSERT INTO `f_subject` VALUES ('21', '读科技图书和杂志。', '1');
INSERT INTO `f_subject` VALUES ('22', '在试验室工作。  ', '1');
INSERT INTO `f_subject` VALUES ('23', '改良品种,培育新水果', '1');
INSERT INTO `f_subject` VALUES ('24', '分析土和金属等的成分.', '1');
INSERT INTO `f_subject` VALUES ('25', '研究自己选择的问题.', '1');
INSERT INTO `f_subject` VALUES ('26', '解算式或数学游戏。', '1');
INSERT INTO `f_subject` VALUES ('27', '学物理课。', '1');
INSERT INTO `f_subject` VALUES ('28', '学化学课。', '1');
INSERT INTO `f_subject` VALUES ('29', '学几何课。', '1');
INSERT INTO `f_subject` VALUES ('30', '学生物课。', '1');
INSERT INTO `f_subject` VALUES ('31', '学校或单位的正式活动.', '1');
INSERT INTO `f_subject` VALUES ('32', '参加社会团体或俱乐部', '1');
INSERT INTO `f_subject` VALUES ('33', '帮助别人解决困难。', '1');
INSERT INTO `f_subject` VALUES ('34', '照顾儿童。', '1');
INSERT INTO `f_subject` VALUES ('35', '晚会、联欢会、茶话会。', '1');
INSERT INTO `f_subject` VALUES ('36', '和大家一起出去郊游。', '1');
INSERT INTO `f_subject` VALUES ('37', '获得心理方面的知识。', '1');
INSERT INTO `f_subject` VALUES ('38', '参加讲座会或辩论会。', '1');
INSERT INTO `f_subject` VALUES ('39', '观看或参加体育比赛。', '1');
INSERT INTO `f_subject` VALUES ('40', '结交新朋友。', '1');
INSERT INTO `f_subject` VALUES ('41', '说服鼓动他人。', '1');
INSERT INTO `f_subject` VALUES ('42', '卖东西。', '1');
INSERT INTO `f_subject` VALUES ('43', '谈论政治。', '1');
INSERT INTO `f_subject` VALUES ('44', '制定计划、参加会议。', '1');
INSERT INTO `f_subject` VALUES ('45', '别人的行为。', '1');
INSERT INTO `f_subject` VALUES ('46', '在社会团体中任职。', '1');
INSERT INTO `f_subject` VALUES ('47', '检查与评价别人的工作', '1');
INSERT INTO `f_subject` VALUES ('48', '结识名流。', '1');
INSERT INTO `f_subject` VALUES ('49', '指导项目小组。', '1');
INSERT INTO `f_subject` VALUES ('50', '参与政治活动。', '1');
INSERT INTO `f_subject` VALUES ('51', '整理好桌面和房间。', '1');
INSERT INTO `f_subject` VALUES ('52', '抄写文件和信件。', '1');
INSERT INTO `f_subject` VALUES ('53', '为领导写报告或公函。', '1');
INSERT INTO `f_subject` VALUES ('54', '查收个人收支情况。', '1');
INSERT INTO `f_subject` VALUES ('55', '参加打字培训班。', '1');
INSERT INTO `f_subject` VALUES ('56', '参加算盘，文秘等培训。', '1');
INSERT INTO `f_subject` VALUES ('57', '参加商业会计培训班。', '1');
INSERT INTO `f_subject` VALUES ('58', '参加情报处理培训班。', '1');
INSERT INTO `f_subject` VALUES ('59', '整理信件、报告、记录等。', '1');
INSERT INTO `f_subject` VALUES ('60', '写商业贸易信。', '1');
INSERT INTO `f_subject` VALUES ('61', '能使用电锯、电钻和锉刀等木工工具。                                                                                                    ', '2');
INSERT INTO `f_subject` VALUES ('62', '知道万用表的使用方法。                                                                                                          ', '2');
INSERT INTO `f_subject` VALUES ('63', '能够修理自行车或其他机械。                                                                                                        ', '2');
INSERT INTO `f_subject` VALUES ('64', '能够使用电钻床、磨床或缝纫机。                                                                                                      ', '2');
INSERT INTO `f_subject` VALUES ('65', '能给家具和木制品刷漆。                                                                                                          ', '2');
INSERT INTO `f_subject` VALUES ('66', '能看建筑等设计图。                                                                                                            ', '2');
INSERT INTO `f_subject` VALUES ('67', '能够修理简单的电气用品。                                                                                                         ', '2');
INSERT INTO `f_subject` VALUES ('68', '能够修理家具。                                                                                                              ', '2');
INSERT INTO `f_subject` VALUES ('69', '能修收录机。                                                                                                               ', '2');
INSERT INTO `f_subject` VALUES ('70', '能简单地修理水管。                                                                                                            ', '2');
INSERT INTO `f_subject` VALUES ('71', '能演奏乐器。                                                                                                               ', '2');
INSERT INTO `f_subject` VALUES ('72', '能参加二部或四部合唱。                                                                                                          ', '2');
INSERT INTO `f_subject` VALUES ('73', '独唱或独奏。                                                                                                               ', '2');
INSERT INTO `f_subject` VALUES ('74', '扮演剧中角色。                                                                                                              ', '2');
INSERT INTO `f_subject` VALUES ('75', '能创作简单的乐曲。                                                                                                            ', '2');
INSERT INTO `f_subject` VALUES ('76', '会跳舞。                                                                                                                 ', '2');
INSERT INTO `f_subject` VALUES ('77', '能绘画、素描或书法。                                                                                                           ', '2');
INSERT INTO `f_subject` VALUES ('78', '能雕该刻、剪纸或泥塑。                                                                                                          ', '2');
INSERT INTO `f_subject` VALUES ('79', '能设计海报、服装或家具。                                                                                                         ', '2');
INSERT INTO `f_subject` VALUES ('80', '写得一手好文章。                                                                                                             ', '2');
INSERT INTO `f_subject` VALUES ('81', '懂得真空管或晶体管的作用。                                                                                                        ', '2');
INSERT INTO `f_subject` VALUES ('82', '能够举例三种含蛋白质多的食品。                                                                                                      ', '2');
INSERT INTO `f_subject` VALUES ('83', '理解铀的裂变。                                                                                                              ', '2');
INSERT INTO `f_subject` VALUES ('84', '能用计算尺、计算器、对数表。                                                                                                       ', '2');
INSERT INTO `f_subject` VALUES ('85', '会使用显微镜。                                                                                                              ', '2');
INSERT INTO `f_subject` VALUES ('86', '能找到三个星座。                                                                                                             ', '2');
INSERT INTO `f_subject` VALUES ('87', '能独立进行调查研究。                                                                                                           ', '2');
INSERT INTO `f_subject` VALUES ('88', '能解释简单的化学式。                                                                                                           ', '2');
INSERT INTO `f_subject` VALUES ('89', '理解人造卫星为什么不落地。                                                                                                        ', '2');
INSERT INTO `f_subject` VALUES ('90', '经常参加学术的会议。                                                                                                           ', '2');
INSERT INTO `f_subject` VALUES ('91', '有向各种人说明解释的能力。', '2');
INSERT INTO `f_subject` VALUES ('92', '常参加社会福利活动。', '2');
INSERT INTO `f_subject` VALUES ('93', '能和大家一起友好相处地工作。', '2');
INSERT INTO `f_subject` VALUES ('94', '善于与年长者相处。', '2');
INSERT INTO `f_subject` VALUES ('95', '会邀请人招待人。', '2');
INSERT INTO `f_subject` VALUES ('96', '能简单易懂地教育儿童。', '2');
INSERT INTO `f_subject` VALUES ('97', '能安排会议等活动顺序。', '2');
INSERT INTO `f_subject` VALUES ('98', '善于体察人心和帮助他人。', '2');
INSERT INTO `f_subject` VALUES ('99', '帮助护理病人或伤员。', '2');
INSERT INTO `f_subject` VALUES ('100', '安排社团组织的各种事务。', '2');
INSERT INTO `f_subject` VALUES ('101', '担任过学生干部并且干得不错。', '2');
INSERT INTO `f_subject` VALUES ('102', '工作上能指导和监督他人。', '2');
INSERT INTO `f_subject` VALUES ('103', '做事充满活力和热情。', '2');
INSERT INTO `f_subject` VALUES ('104', '有效地用自身的做法调动他人。', '2');
INSERT INTO `f_subject` VALUES ('105', '销售能力强。', '2');
INSERT INTO `f_subject` VALUES ('106', '曾作为俱乐部或社团的负责人。', '2');
INSERT INTO `f_subject` VALUES ('107', '向领导提出建议或反映意见。', '2');
INSERT INTO `f_subject` VALUES ('108', '有开创事业的能力。', '2');
INSERT INTO `f_subject` VALUES ('109', '知道怎样做能成为一个优秀的领导者。', '2');
INSERT INTO `f_subject` VALUES ('110', '健谈善辩。', '2');
INSERT INTO `f_subject` VALUES ('111', '会熟练地打印中文。', '2');
INSERT INTO `f_subject` VALUES ('112', '会用外文打字机或复印机。', '2');
INSERT INTO `f_subject` VALUES ('113', '能快速记笔记和抄写文章。', '2');
INSERT INTO `f_subject` VALUES ('114', '善于整理保管文件和资料。', '2');
INSERT INTO `f_subject` VALUES ('115', '善于从事事务性的工作。', '2');
INSERT INTO `f_subject` VALUES ('116', '会用算盘。', '2');
INSERT INTO `f_subject` VALUES ('117', '能在短时间内分类和处理大量文件。', '2');
INSERT INTO `f_subject` VALUES ('118', '能使用计算机。', '2');
INSERT INTO `f_subject` VALUES ('119', '能搜集数据。', '2');
INSERT INTO `f_subject` VALUES ('120', '善于为自己或集体作财务预算表。', '2');

-- ----------------------------
-- Table structure for f_user
-- ----------------------------
DROP TABLE IF EXISTS `f_user`;
CREATE TABLE `f_user` (
  `wxid` varchar(32) NOT NULL,
  `tel` varchar(16) DEFAULT NULL,
  `username` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`wxid`),
  KEY `index_tel` (`tel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of f_user
-- ----------------------------

-- ----------------------------
-- Table structure for ss_department
-- ----------------------------
DROP TABLE IF EXISTS `ss_department`;
CREATE TABLE `ss_department` (
  `id` varchar(32) NOT NULL,
  `name` varchar(128) DEFAULT NULL,
  `linkman` varchar(64) DEFAULT NULL,
  `tel` varchar(32) DEFAULT NULL,
  `status` int(8) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ss_department
-- ----------------------------

-- ----------------------------
-- Table structure for ss_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `ss_dictionary`;
CREATE TABLE `ss_dictionary` (
  `ID` varchar(64) NOT NULL,
  `SUPER_ID` varchar(64) DEFAULT NULL,
  `DATADICVAL` varchar(500) DEFAULT NULL,
  `NAME` varchar(500) DEFAULT NULL,
  `EXPR` varchar(100) DEFAULT NULL,
  `REMARK` text,
  `TAXIS` int(11) DEFAULT NULL,
  `STRTUS` varchar(32) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ss_dictionary
-- ----------------------------

-- ----------------------------
-- Table structure for ss_permission
-- ----------------------------
DROP TABLE IF EXISTS `ss_permission`;
CREATE TABLE `ss_permission` (
  `id` varchar(32) NOT NULL,
  `name` varchar(200) DEFAULT NULL,
  `permission_key` varchar(200) DEFAULT NULL,
  `is_menu` int(1) DEFAULT NULL,
  `menu_url` varchar(1000) DEFAULT NULL,
  `menu_icon` varchar(200) DEFAULT NULL,
  `order_no` int(10) DEFAULT NULL,
  `parent_id` varchar(32) DEFAULT NULL,
  `creator` varchar(32) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `modifier` varchar(32) DEFAULT NULL,
  `modify_date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_SS_PERMISSION_PARENT_ID` (`parent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ss_permission
-- ----------------------------
INSERT INTO `ss_permission` VALUES ('1', '安全管理', 'systemmanage:menu', '1', '', '', '8', null, null, null, '1', '2018-04-02');
INSERT INTO `ss_permission` VALUES ('1-1', '用户管理', 'usermanage:menu', '1', '/systemmanage/user', null, '1', '1', null, null, null, null);
INSERT INTO `ss_permission` VALUES ('1-1-1', '查询', 'usermanage:query', '1', '', '', '1', '1-1', null, null, '1', '2018-08-07');
INSERT INTO `ss_permission` VALUES ('1-1-2', '新增', 'usermanage:add', '1', '', '', '2', '1-1', null, null, '1', '2018-08-07');
INSERT INTO `ss_permission` VALUES ('1-1-3', '修改', 'usermanage:edit', null, null, null, '3', '1-1', null, null, null, null);
INSERT INTO `ss_permission` VALUES ('1-1-4', '删除', 'usermanage:delete', null, null, null, '4', '1-1', null, null, null, null);
INSERT INTO `ss_permission` VALUES ('1-2', '权限管理', 'permissionmanage:menu', '1', '/systemmanage/permission', null, '3', '1', null, null, null, null);
INSERT INTO `ss_permission` VALUES ('1-2-1', '查询', 'permissionmanage:query', null, null, null, '1', '1-2', null, null, null, null);
INSERT INTO `ss_permission` VALUES ('1-2-2', '新增', 'permissionmanage:add', null, null, null, '2', '1-2', null, null, null, null);
INSERT INTO `ss_permission` VALUES ('1-2-3', '修改', 'permissionmanage:edit', null, null, null, '3', '1-2', null, null, null, null);
INSERT INTO `ss_permission` VALUES ('1-2-4', '删除', 'permissionmanage:delete', null, null, null, '4', '1-2', null, null, null, null);
INSERT INTO `ss_permission` VALUES ('1-3', '角色管理', 'rolemanage:menu', '1', '/systemmanage/role', null, '2', '1', null, null, null, null);
INSERT INTO `ss_permission` VALUES ('1-3-1', '查询', 'rolemanage:query', null, null, null, '1', '1-3', null, null, null, null);
INSERT INTO `ss_permission` VALUES ('1-3-2', '新增', 'rolemanage:add', null, null, null, '2', '1-3', null, null, null, null);
INSERT INTO `ss_permission` VALUES ('1-3-3', '修改', 'rolemanage:edit', null, null, null, '3', '1-3', null, null, null, null);
INSERT INTO `ss_permission` VALUES ('1-3-4', '删除', 'rolemanage:delete', null, null, null, '4', '1-3', null, null, null, null);
INSERT INTO `ss_permission` VALUES ('1-4-1', '查询', 'deptmanage:query', null, null, null, '1', '1e71f19558664f4095ebe59a81c18ecc', null, null, null, null);
INSERT INTO `ss_permission` VALUES ('1-4-2', '新增', 'deptmanage:add', null, null, null, '2', '1e71f19558664f4095ebe59a81c18ecc', null, null, null, null);
INSERT INTO `ss_permission` VALUES ('1-4-3', '修改', 'deptmanage:edit', null, null, null, '3', '1e71f19558664f4095ebe59a81c18ecc', null, null, null, null);
INSERT INTO `ss_permission` VALUES ('1-4-4', '删除', 'deptmanage:delete', null, null, null, '4', '1e71f19558664f4095ebe59a81c18ecc', null, null, null, null);
INSERT INTO `ss_permission` VALUES ('1e71f19558664f4095ebe59a81c18ecc', '部门管理', 'deptManager:menu', '1', 'systemmanage/dept', '', '2', '1', '1', '2017-11-12', '1', '2017-11-12');

-- ----------------------------
-- Table structure for ss_role
-- ----------------------------
DROP TABLE IF EXISTS `ss_role`;
CREATE TABLE `ss_role` (
  `id` varchar(32) NOT NULL,
  `name` varchar(200) DEFAULT NULL,
  `description` varchar(2000) DEFAULT NULL,
  `creator` varchar(32) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `modifier` varchar(32) DEFAULT NULL,
  `modify_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ss_role
-- ----------------------------
INSERT INTO `ss_role` VALUES ('1', '系统管理员角色', '系统管理员角色：负责用户管理和业务管理，以及角色和权限的查询。', null, null, '1', '2018-05-22');

-- ----------------------------
-- Table structure for ss_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `ss_role_permission`;
CREATE TABLE `ss_role_permission` (
  `role_id` varchar(32) NOT NULL,
  `permission_id` varchar(32) NOT NULL,
  PRIMARY KEY (`role_id`,`permission_id`),
  KEY `FK_SS_ROLE_PERMISSION_PERMI_ID` (`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ss_role_permission
-- ----------------------------
INSERT INTO `ss_role_permission` VALUES ('1', '1');
INSERT INTO `ss_role_permission` VALUES ('1', '1-1');
INSERT INTO `ss_role_permission` VALUES ('1', '1-1-1');
INSERT INTO `ss_role_permission` VALUES ('1', '1-1-2');
INSERT INTO `ss_role_permission` VALUES ('1', '1-1-3');
INSERT INTO `ss_role_permission` VALUES ('1', '1-1-4');
INSERT INTO `ss_role_permission` VALUES ('1', '1-2');
INSERT INTO `ss_role_permission` VALUES ('1', '1-2-1');
INSERT INTO `ss_role_permission` VALUES ('1', '1-2-2');
INSERT INTO `ss_role_permission` VALUES ('1', '1-2-3');
INSERT INTO `ss_role_permission` VALUES ('1', '1-2-4');
INSERT INTO `ss_role_permission` VALUES ('1', '1-3');
INSERT INTO `ss_role_permission` VALUES ('1', '1-3-1');
INSERT INTO `ss_role_permission` VALUES ('1', '1-3-2');
INSERT INTO `ss_role_permission` VALUES ('1', '1-3-3');
INSERT INTO `ss_role_permission` VALUES ('1', '1-3-4');
INSERT INTO `ss_role_permission` VALUES ('1', '1-4-1');
INSERT INTO `ss_role_permission` VALUES ('1', '1-4-2');
INSERT INTO `ss_role_permission` VALUES ('1', '1-4-3');
INSERT INTO `ss_role_permission` VALUES ('1', '1-4-4');
INSERT INTO `ss_role_permission` VALUES ('1', '1e71f19558664f4095ebe59a81c18ecc');

-- ----------------------------
-- Table structure for ss_task_config
-- ----------------------------
DROP TABLE IF EXISTS `ss_task_config`;
CREATE TABLE `ss_task_config` (
  `task_id` varchar(50) NOT NULL,
  `task_name` varchar(1000) NOT NULL,
  `cron_expr` varchar(100) NOT NULL,
  `job_class` varchar(1000) NOT NULL,
  `state` varchar(50) NOT NULL,
  PRIMARY KEY (`task_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ss_task_config
-- ----------------------------
INSERT INTO `ss_task_config` VALUES ('1', '家宽定时跑数据程序', '0 0/1 * * * ?', 'com.zznode.homebroadband.job.HomeBroadbandJob', '无效');

-- ----------------------------
-- Table structure for ss_user
-- ----------------------------
DROP TABLE IF EXISTS `ss_user`;
CREATE TABLE `ss_user` (
  `id` varchar(32) NOT NULL,
  `login_name` varchar(50) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `salt` varchar(200) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `dept` varchar(200) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `tel` varchar(32) DEFAULT NULL,
  `creator` varchar(32) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `modifier` varchar(32) DEFAULT NULL,
  `modify_date` date DEFAULT NULL,
  `state` varchar(32) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ss_user
-- ----------------------------
INSERT INTO `ss_user` VALUES ('1', 'admin', 'ec157483f4d7e1506ef9999456751389', 'f57VHV7sQ4', 'admin', null, null, null, null, null, '1', '2018-03-14', '启用', null);

-- ----------------------------
-- Table structure for ss_user_role
-- ----------------------------
DROP TABLE IF EXISTS `ss_user_role`;
CREATE TABLE `ss_user_role` (
  `user_id` varchar(32) NOT NULL,
  `role_id` varchar(32) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FK_SS_USER_ROLE_ROLE_ID` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ss_user_role
-- ----------------------------
INSERT INTO `ss_user_role` VALUES ('1', '1');

-- ----------------------------
-- Table structure for ss_wxuser
-- ----------------------------
DROP TABLE IF EXISTS `ss_wxuser`;
CREATE TABLE `ss_wxuser` (
  `id` varchar(32) NOT NULL COMMENT '主键id',
  `phone` varchar(32) DEFAULT NULL COMMENT '对应账号id',
  `openid` varchar(100) DEFAULT NULL COMMENT '用户微信唯一id',
  `name` varchar(100) DEFAULT NULL COMMENT '姓名',
  `nickname` varchar(100) DEFAULT NULL COMMENT '昵称',
  `sex` int(11) DEFAULT NULL COMMENT '性别',
  `headimgurl` varchar(500) DEFAULT NULL COMMENT '头像',
  `subscribe` int(11) unsigned zerofill DEFAULT '00000000000' COMMENT '是否关注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ss_wxuser
-- ----------------------------
INSERT INTO `ss_wxuser` VALUES ('264bcd1354f64655801906f33a9fb3a0', '13980562043', 'of4qa0f0s2UVbNnTsaESGvjLwgew', '唐军', 'Free Sky', '1', 'http://thirdwx.qlogo.cn/mmopen/PiajxSqBRaEKicvcWuHTibrWPwjhRrhVAZrEa5Lk2OkVgby7mlQ2ibsGHKHS4zqE3DhABChjicEONWvJHJ58vKUNic8A/132', '00000000001');
INSERT INTO `ss_wxuser` VALUES ('e2ac4908fd9545bca278e763936514ae', '15718035807', 'oe4F71VP_PE42pLeTiPx-YTtUTjo', '韩孔斌', '！', '1', 'http://thirdwx.qlogo.cn/mmopen/BvnXmC5jDCHt8VsV15XrP65Ymjzjn0B8udSUI1Tp9sdiaCaDBUj8DxMEgVHhaMlMRsmFXVica3wKLu2slD9q32DY43OEdoC8Lu/132', '00000000001');

-- ----------------------------
-- Table structure for weixin_account
-- ----------------------------
DROP TABLE IF EXISTS `weixin_account`;
CREATE TABLE `weixin_account` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `accountname` varchar(200) DEFAULT NULL COMMENT '公众帐号名称',
  `accounttoken` varchar(200) DEFAULT NULL COMMENT '公众帐号TOKEN',
  `accountnumber` varchar(200) DEFAULT NULL COMMENT '公众微信号',
  `accounttype` varchar(50) DEFAULT NULL COMMENT '公众号类型',
  `accountemail` varchar(200) DEFAULT NULL COMMENT '电子邮箱',
  `accountdesc` varchar(500) DEFAULT NULL COMMENT '公众帐号描述',
  `accountaccesstoken` varchar(1000) DEFAULT NULL COMMENT 'ACCESS_TOKEN',
  `accountappid` varchar(200) DEFAULT NULL COMMENT '公众帐号APPID',
  `accountappsecret` varchar(500) DEFAULT NULL COMMENT '公众帐号APPSECRET',
  `ADDTOEKNTIME` datetime DEFAULT NULL COMMENT 'TOKEN获取时间',
  `USERNAME` varchar(50) DEFAULT NULL COMMENT '所属系统用户',
  `WEIXIN_ACCOUNTID` varchar(100) DEFAULT NULL COMMENT '微信公众号所属原始id',
  `accountjsticket` varchar(1000) DEFAULT NULL COMMENT '公众帐号jsapi_ticket',
  `addtickettime` datetime DEFAULT NULL COMMENT 'TICKET获取时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weixin_account
-- ----------------------------
INSERT INTO `weixin_account` VALUES ('402881e8461795c201461795c2e90000', '宏图志愿', 'u125170251', 'hongtuzhiyuan123', '1', '3089868755@qq.com', '宏图志愿', '', 'wx2b2b5c7488a0feda', 'bec0203873b279f5a19df74b789d913a', '2018-05-30 00:18:10', 'liushaojin', null, 'HoagFKDcsGMVCIY2vOjf9s10hwfWoX4IT_4FyzR7gUL27Am4r81hWcnWFnuI2yJ-2G2gwUN92Mff1YeYmnfNxw', '2018-05-12 11:29:47');

-- ----------------------------
-- Function structure for queryChildPermission
-- ----------------------------
DROP FUNCTION IF EXISTS `queryChildPermission`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `queryChildPermission`(rootId VARCHAR(1000)) RETURNS varchar(21840) CHARSET utf8
BEGIN
 DECLARE sTemp VARCHAR(21840);
   DECLARE sTempChd VARCHAR(21840);
   SET sTemp = '$';
   SET sTempChd =cast(rootId as CHAR);
	 IF rootId is null THEN
	  	SELECT group_concat(id) INTO sTempChd FROM ss_permission;
  	end IF;
		WHILE sTempChd is not null DO
				SET sTemp = concat(sTemp,',',sTempChd);
				SELECT group_concat(id) INTO sTempChd FROM ss_permission where FIND_IN_SET(parent_Id,sTempChd)>0;
		END WHILE;
RETURN sTemp;
END
;;
DELIMITER ;
