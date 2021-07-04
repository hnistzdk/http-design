/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : http

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 19/05/2021 10:42:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for http_article
-- ----------------------------
DROP TABLE IF EXISTS `http_article`;
CREATE TABLE `http_article`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '作者id',
  `article_title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文章标题',
  `article_intro` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '文章简介',
  `article_text` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '文章内容',
  `article_up` int NULL DEFAULT NULL COMMENT '文章点赞数',
  `article_collection` int NULL DEFAULT NULL COMMENT '文章收藏数',
  `article_share` int NULL DEFAULT NULL COMMENT '文章分享数',
  `article_time` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发布时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of http_article
-- ----------------------------
INSERT INTO `http_article` VALUES (1, 'zdk', 'HTTP协议详解', '超文本传输协议（英文：HyperText Transfer Protocol，缩写：HTTP）是一种用于分布式、协作式和超媒体信息系统的应用层协议。HTTP是万维网的数据通信的基础。\r\n\r\nHTTP的发展是由蒂姆·伯纳斯-李于1989年在欧洲核子研究组织（CERN）所发起。HTTP的标准制定由万维网协会（World Wide Web Consortium，W3C）和互联网工程任务组（Internet Engineering Task Force，IETF）进行协调，最终发布了一系列的RFC，其中最著名的是1999年6月公布的 RFC 2616，定义了HTTP协议中现今广泛使用的一个版本——HTTP 1.1。\r\n\r\n2014年12月，互联网工程任务组（IETF）的Hypertext Transfer Protocol Bis（httpbis）工作小组将HTTP/2标准提议递交至IESG进行讨论，于2015年2月17日被批准。 HTTP/2标准于2015年5月以RFC 7540正式发表，取代HTTP 1.1成为HTTP的实现标准。', 'HTTP协议定义Web客户端如何从Web服务器请求Web页面，以及服务器如何把Web页面传送给客户端。HTTP协议采用了请求/响应模型。客户端向服务器发送一个请求报文，请求报文包含请求的方法、URL、协议版本、请求头部和请求数据。服务器以一个状态行作为响应，响应的内容包括协议的版本、成功或者错误代码、服务器信息、响应头部和响应数据。\r\n\r\n以下是 HTTP 请求/响应的步骤：\r\n\r\n\\1. 客户端连接到Web服务器\r\n一个HTTP客户端，通常是浏览器，与Web服务器的HTTP端口（默认为80）建立一个TCP套接字连接。例如，http://www.baidu.com。\r\n\r\n\\2. 发送HTTP请求\r\n通过TCP套接字，客户端向Web服务器发送一个文本的请求报文，一个请求报文由请求行、请求头部、空行和请求数据4部分组成。\r\n\r\n\\3. 服务器接受请求并返回HTTP响应\r\nWeb服务器解析请求，定位请求资源。服务器将资源复本写到TCP套接字，由客户端读取。一个响应由状态行、响应头部、空行和响应数据4部分组成。\r\n\r\n\\4. 释放连接TCP连接\r\n若connection 模式为close，则服务器主动关闭TCP连接，客户端被动关闭连接，释放TCP连接;若connection 模式为keepalive，则该连接会保持一段时间，在该时间内可以继续接收请求;\r\n\r\n\\5. 客户端浏览器解析HTML内容\r\n客户端浏览器首先解析状态行，查看表明请求是否成功的状态代码。然后解析每一个响应头，响应头告知以下为若干字节的HTML文档和文档的字符集。客户端浏览器读取响应数据HTML，根据HTML的语法对其进行格式化，并在浏览器窗口中显示。\r\n\r\n例如：在浏览器地址栏键入URL，按下回车之后会经历以下流程：\r\n\r\n浏览器向 DNS 服务器请求解析该 URL 中的域名所对应的 IP 地址;\r\n解析出 IP 地址后，根据该 IP 地址和默认端口 80，和服务器建立TCP连接;\r\n浏览器发出读取文件(URL 中域名后面部分对应的文件)的HTTP 请求，该请求报文作为 TCP 三次握手的第三个报文的数据发送给服务器;\r\n服务器对浏览器请求作出响应，并把对应的 html 文本发送给浏览器;\r\n释放 TCP连接;\r\n浏览器将该 html 文本并显示内容; 　', 1, 1, 1, '2021-05-21');
INSERT INTO `http_article` VALUES (2, '333', 'AJAX中POST请求注意点(header头)', '在进行AJAX请求需要注意POST的区别', '在我们进行AJAX请求的过程中,GET请求是简单可行的.例如\nxmlhttp.open(\"GET\",\"test1.txt\",true);\nxmlhttp.send();\n这是简单可行的,我们需要把有用的数据拼接到URL后面即可,就像这样:\nxmlhttp.open(\"GET\",\"demo_get2.asp?fname=Bill&lname=Gates\",true);\nxmlhttp.send();\n但是遇到数据量超过了URL的承载量,我们就需要另外想想办法了,这个时候,我们要使用post请求\n,但是post请求更加复杂,首先具体的格式如下:\nxmlhttp.open(\"POST\",\"demo_post.asp\",true);\nxmlhttp.send();\n但是我们如果想让他像表单一样传送数据需要加上header头即可:\nxmlhttp.open(\"POST\",\"ajax_test.asp\",true);\nxmlhttp.setRequestHeader(\"Content-type\",\"application/x-www-form-urlencoded\");\nxmlhttp.send(\"fname=Bill&lname=Gates\");\nxmlhttp.setRequestHeader(“Content-type”,”application/x-www-form-urlencoded”);\r\n', 1, 1, 1, '2021-05-03');
INSERT INTO `http_article` VALUES (6, '111', 'vue', 'vue介绍', '这份 cookbook 和指南的不同之处在哪里？存在的意义是什么？\r\n\r\n更专注：在指南里，我们实际上是在讲一个故事。每个章节都以之前章节的知识进行构建和假设。而在 cookbook 里，每个案例都有各自的代表性。也就是说每个案例都专注于 Vue 的某个特定方面，而不是一个概览。\r\n\r\n更有深度：为了避免指南写得太长，我们试着只包含了尽可能简单的示例来帮助你理解每个功能，然后就奔下一个话题了。在 cookbook 里，我们以更生动的形式包含了更复杂的示例并结合特性。每个案例都可以尽可能的翔实，以彻底探索这个领域。\r\n\r\n传授 JavaScript：在指南里，我们假设你至少具有 ES5 JavaScript 的中级水平。例如，我们不会解释 Array.prototype.filter 在计算属性中是如何过滤一个列表的。然而在 cookbook 里，我们将对一些必要的 JavaScript 特性 (包括 ES6/2015+) 进行探索和解释，以帮助我们构建更好的 Vue 应用。\r\n\r\n探索生态系统：对于高级特性，我们会假设你已经对生态系统有一定了解。例如，如果你想在 webpack 中使用单文件组件，我们不会解释如何在 webpack 中配置 Vue 以外的部分。在 cookbook 里，我们有空间去更深度探索这些生态系统中的库——至少能到对 Vue 开发者普遍使用的程度。', 0, 0, 0, '2021-05-11');
INSERT INTO `http_article` VALUES (7, '222', 'Ajax跨域', 'ajax出现请求跨域错误问题,主要原因就是因为浏览器的“同源策略”', 'jsonp解决跨域问题是一个比较古老的方案(实际中不推荐使用),这里做简单介绍(实际项目中如果要使用JSONP,一般会使用JQ等对JSONP进行了封装的类库来进行ajax请求)。', 0, 0, 0, '2021-05-10');
INSERT INTO `http_article` VALUES (8, 'zdk', '测试编辑xxx', '大健康临时冻结啊', '大结局了打击sad健康啦', 0, 0, 0, '2021-05-10');
INSERT INTO `http_article` VALUES (9, 'zs', 'asdljak ', '打开水', '大速度快解散', 0, 0, 0, '2021-05-07');
INSERT INTO `http_article` VALUES (14, 'zdk', '测试第二个编辑', '萨达', '阿萨达', 0, 0, 0, '2021-05-16');
INSERT INTO `http_article` VALUES (20, 'zdk', '使用拦截器或者AOP实现权限管理(OA系统中实现权限控制)', '在开发类似与OA管理系统类型的项目中，经常需要设置到权限管理。例如对某个部门的人员CURD操作，默认是该部门的普通员工是不会有该权限的。但若某个员工升级为该部分的负责人。则此时它就拥有对该部门的CURD操作，此时管理员就应该对该员工赋予该权限。这篇文章教大家如果处理该需求，即权限管理。', '首先应该明白，在权限管理中，权限的控制对象是方法:\r\n在我们J2EE开发过程中，实现权限的控制主要有两种方法:\r\n第一种方式：\r\n利用struts2的拦截器\r\n第二种方式：\r\n利用spring的AOP技术', 0, 0, 0, '2021-05-16');
INSERT INTO `http_article` VALUES (28, 'zdk', '阿萨大师', '111', '111', 0, 0, 0, '2021-05-16');
INSERT INTO `http_article` VALUES (30, 'zdk', '222', '2222', '222', 0, 0, 0, '2021-05-16');
INSERT INTO `http_article` VALUES (32, 'zdk', '333', '333', '333', 0, 0, 0, '2021-05-16');
INSERT INTO `http_article` VALUES (34, 'zdk', '123', '123', '123', 0, 0, 0, '2021-05-16');
INSERT INTO `http_article` VALUES (35, 'zdk', '张金硕', '张金树', '张金硕', 0, 0, 0, '2021-05-17');
INSERT INTO `http_article` VALUES (36, 'zdk112', 'sahdkj ', '挖就嗲', '吉大三等奖埃里克', 0, 0, 0, '2021-05-18');

-- ----------------------------
-- Table structure for http_user
-- ----------------------------
DROP TABLE IF EXISTS `http_user`;
CREATE TABLE `http_user`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of http_user
-- ----------------------------
INSERT INTO `http_user` VALUES (1, 'zdk', '123');
INSERT INTO `http_user` VALUES (2, '111', '123');
INSERT INTO `http_user` VALUES (3, '222', '123');
INSERT INTO `http_user` VALUES (4, 'zs', '123');
INSERT INTO `http_user` VALUES (5, '张迪凯', '123');
INSERT INTO `http_user` VALUES (7, 'zdk11', '123');
INSERT INTO `http_user` VALUES (8, 'zdk112', '123');

SET FOREIGN_KEY_CHECKS = 1;
