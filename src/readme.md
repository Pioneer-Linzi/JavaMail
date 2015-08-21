1.   java mail 
	用以发送简单的邮件内容 ，
	邮件的配置文件可以 配置文件中写入，
 * 略去设置邮箱中的各种的过程，直接从配置文件中读取要发送的内容与基本的配置文件 
 * 只要用setTo("mailaddress@host");来设置发送给谁就行了，
 * 然后调用sendMessage();来发送邮件
 
 这里也可调用里面的set 的方法来对各各参数进行初始化，也不用从配置文件中读取的方式
 配置文件 ： src根目录下 文件名为： email_template.properties
 //按自己的需来填写
 subject=
content=
from= 
host=smtp.qq.com
username=
password=
 ＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
 这里要注意的是我们要导入 java EE 中的两个包，
  一个是mail.jar
  			activation.jar
  这两个包是一个定要导的
 