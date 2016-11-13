package com.app.gongza.asgzdesign.activities.demo.scrollablelayout.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

import com.app.gongza.asgzdesign.R;
import com.app.gongza.asgzdesign.activities.demo.scrollablelayout.fragment.base.ScrollAbleFragment;
import com.app.gongza.libs.view.scrollablelayout.ScrollableHelper;


public class WebViewFragment extends ScrollAbleFragment implements ScrollableHelper.ScrollableContainer{

    private WebView webView;
    private EditText mAddressEdt;
    private String htmlStr="<div class=\"main-wrap content-wrap\">\n" +
            "<div class=\"headline\">\n" +
            "\n" +
            "<div class=\"img-place-holder\"></div>\n" +
            "\n" +
            "\n" +
            "\n" +
            "</div>\n" +
            "\n" +
            "<div class=\"content-inner\">\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "<div class=\"question\">\n" +
            "<h2 class=\"question-title\"></h2>\n" +
            "\n" +
            "<div class=\"answer\">\n" +
            "\n" +
            "<div class=\"content\">\n" +
            "<p style=\"text-align: center;\">* * *</p>\n" +
            "<p style=\"text-align: center;\">不是我不明白</p>\n" +
            "<p style=\"text-align: center;\">这世界变化快</p>\n" +
            "<p style=\"text-align: center;\">* * *</p>\n" +
            "</div>\n" +
            "</div>\n" +
            "\n" +
            "\n" +
            "</div>\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "<div class=\"question\">\n" +
            "<h2 class=\"question-title\">你有哪些大开眼界的经历？</h2>\n" +
            "\n" +
            "<div class=\"answer\">\n" +
            "\n" +
            "<div class=\"meta\">\n" +
            "<img class=\"avatar\" src=\"http://pic1.zhimg.com/da8e974dc_is.jpg\">\n" +
            "<span class=\"author\">知乎用户，</span><span class=\"bio\">墨尔本外科住院医生，英澳两国执业</span>\n" +
            "</div>\n" +
            "\n" +
            "<div class=\"content\">\n" +
            "<p>某一年和几个朋友聚会，一个朋友是兽医，他 on call 忽然电话响了，说要去急诊手术，一只小母狗难产</p>\n" +
            "<p>我们几个医生呵呵，我作为唯一一个在外科工作的医生默默的神之鄙视了一下</p>\n" +
            "<p>朋友问，要一起来吗？我们剩下来几个医生就嘿嘿一起去凑热闹了</p>\n" +
            "<p>到了诊所，一只小黑狗小狗很可怜，肚子很大，一直在抖</p>\n" +
            "<p>朋友说，要上麻醉</p>\n" +
            "<p>我问，麻醉师呢？</p>\n" +
            "<p>朋友说，『我就是』，利索的面罩麻醉，插管，接呼吸机</p>\n" +
            "<p>不到一分钟上好管子了</p>\n" +
            "<p>我也洗手上（动物手术）台</p>\n" +
            "<p>问『器械护士呢？』</p>\n" +
            "<p>他已经消完毒，手术刀拿手里了，用看傻逼的眼神看着我</p>\n" +
            "<p>正中切口切开，子宫马上就露出来了</p>\n" +
            "<p>子宫切开，一股羊水涌出，他极其利索的掏出一只巴掌大的粉红小狗崽</p>\n" +
            "<p>我像举着狮子王一样举着这只可爱到极点的小生命</p>\n" +
            "<p><img class=\"content-image\" src=\"http://pic3.zhimg.com/70/v2-0dd482016db8fe93829d37912d568a36_b.jpg\" alt=\"\" /></p>\n" +
            "<p>说&mdash;&mdash;欢迎来到这个世界!</p>\n" +
            "<p>接着发现子宫还是很大&mdash;&mdash;朋友一只接着一只从子宫里挤出了 7 只小狗崽</p>\n" +
            "<p>我惊讶的问: 『怎么这么能生』</p>\n" +
            "<p>朋友再一次很看傻逼的眼神看着我&mdash;&mdash;『狗本来就是一胎多只的动物』</p>\n" +
            "<p><img class=\"content-image\" src=\"http://pic2.zhimg.com/70/v2-ba5587a9b163e2e4f055e8ec868b9b85_b.jpg\" alt=\"\" /></p>\n" +
            "<p>接着就是缝合，醒麻醉，把小狗崽放在妈妈的肚子上，他们自己会去找乳头喂奶，十分可爱，让人爱不释手</p>\n" +
            "<p>怪不得兽医是一个挺让人开心的职业，虽然做的工作是有点糙，但是『病人』都特别的可爱，也没有医闹</p>\n" +
            "<p>这事让我从此对于兽医这个职业的认识更加深刻了很多</p>\n" +
            "</div>\n" +
            "</div>\n" +
            "\n" +
            "<div class=\"answer\">\n" +
            "\n" +
            "<div class=\"meta\">\n" +
            "<img class=\"avatar\" src=\"http://pic2.zhimg.com/06a79bbfd34d12c327bf478eb13391bd_is.jpg\">\n" +
            "<span class=\"author\">Vega Liu，</span><span class=\"bio\">一句话介绍不了……</span>\n" +
            "</div>\n" +
            "\n" +
            "<div class=\"content\">\n" +
            "<p>虽然也算是给我开了眼界，但应该算是职场性骚扰吧。</p>\n" +
            "<p>以前在某投资管理公司工作了三个月，人力主管，该公司在我去的时候除了副总是女的，其他员工全部是男性，后来副总在我去了不到一个月后离职，唯一的女性成了我。</p>\n" +
            "<p>去的第三个月，正至春节，公司年会饭后，老板请优秀员工第二轮唱歌，我推辞说不去了，我的包和手机都被男同事们藏起来，然后被拖上车，到了地方才知道&hellip;&hellip;唱歌，是唱歌，第一次进夜总会唱歌&hellip;&hellip;公主换了几十个慢慢挑（很好奇夜总会到底有多少公主），穿着齐 B 小短裙 8 厘米高跟鞋，浓妆艳抹基本看不出原来长什么样，一片片白花花的大腿和胸部，瞬间觉得穿着高领毛衣和羽绒背心的我坐这里多不搭调，反正是环肥燕瘦供君选择，有的看起来比我还小，估计就 18 左右，还问我要不要点，少爷也可以，第一次知道原来女性也可以玩夜总会&hellip;&hellip;我说不用我马上就走，不许，说，不要少爷也行，从公司里面挑一个&hellip;&hellip;然后公司里一平时跟我关系不错的帅哥说我陪你，我对他感谢一笑以为他是帮我解围，他小声说这里的女人没意思，你帮我随便挑一个，我就帮他挑了一个，妆看起来淡点清纯点的，还有几个挑了两个公主&hellip;&hellip;</p>\n" +
            "<p>我以空气不好为由搬了张沙发墩一个人坐到了包房坐门口边上，公主们已经坐定&hellip;&hellip;刚开始男同事们一个个还有点腼腆，唱了几首歌，几杯酒下肚，灯光暧昧，公主们也造起了气氛，音乐也开始嗨起来，还有隐藏舞台，滑门打开便是薄纱妖娆舞女，沙发上开始了各种上下其手扭动娇喘，不可描述，平时看起来这么严肃的老板，XX 商业银行的高高管玩得也是那么的如鱼得水&hellip;&hellip;帮我解围的帅哥身边更是围了 3 个公主，呵呵，公主也服务也是要挑客人颜值的。</p>\n" +
            "<p>我看不下去起身准备出去，帮我解围的帅哥趁着两分酒意，过来一把抱住我&hellip;&hellip;MB，我觉得自己平时能拧起一桶矿泉水，确怎么也挣脱不了，这时候几个公主见我很尴尬跑过来帮我解围，叫着：不许抱她，不许抱她，抱我抱我&hellip;&hellip;把那帅哥拖走了，真的是很感谢她们，虽然从来对做这行的女性没有鄙视之意，也没什么好感，但这次真的让我感觉到，她们心里的善良，我闪了出去，跑到洗手间，呆了好久，一个公主来洗手间，我就让她帮忙把我的包拿了出来，我把我当天买的一大包零食全部送给了她，让她帮我感谢其他帮忙的公主们&hellip;&hellip;你们真的是我的公主！</p>\n" +
            "<p>节后，辞职&hellip;&hellip;</p>\n" +
            "</div>\n" +
            "</div>\n" +
            "\n" +
            "<div class=\"answer\">\n" +
            "\n" +
            "<div class=\"meta\">\n" +
            "<img class=\"avatar\" src=\"http://pic1.zhimg.com/f637cf710_is.jpg\">\n" +
            "<span class=\"author\">王瑞恩，</span><span class=\"bio\">老王力气大无穷 双手举起纸灯笼</span>\n" +
            "</div>\n" +
            "\n" +
            "<div class=\"content\">\n" +
            "<p>昨天刚刚结了一个家暴案件的量刑，辩诉交易是另外一位检察官做的，我只是负责量刑听证。</p>\n" +
            "<p>我开始拿到案卷的时候很诧异：为什么默认是重罪(felony）的家暴案件，可以给出按照轻罪（Misdemeanor）来判且直接缓刑的认罪条件，而且检方和缓刑官都不建议签发禁止接触令。</p>\n" +
            "<p>同事说，你看看被告的生日。</p>\n" +
            "<p>我才发现，这个案子的被告老太太已经 92 岁了，而受害人有 96 岁，</p>\n" +
            "<p>有一次被告忘了按时吃阿普唑仑（一种治疗焦虑症的药），和受害人吵起来，两人一人拿着切肉刀，一个抄起磨刀棒，从厨房叮铃咣啷一直打到楼下，老头不敌，向邻居家方向跑去求救，老太太紧追不舍，一刀捅过去，刀刺进邻居家的墙（美国房屋大部分是木质结构，这里的墙也是木制的，毕竟两人也只是肉体凡胎）。</p>\n" +
            "<p>万幸的是，两人刀光剑影好一阵子，居然都毫发无伤。</p>\n" +
            "<p>邻居报警，警察将老太太带走了，大抵如此。</p>\n" +
            "<p>检方，辩护律师和监狱都很犯难，老太太一直闹着，说这日子不过了，他竟敢让警察抓我？！好吧，我就去蹲监狱了，你们别拦着我。</p>\n" +
            "<p>监狱那边找到缓刑官，说你们也和检方一起劝劝老太太吧，我们怎么请的起这座佛啊。</p>\n" +
            "<p>好不容易把老太太劝好了，说人家监狱也不敢要您啊，好好缓刑，好好过日子，老太太才勉强签了认罪协议。</p>\n" +
            "<p>听证的时候，96 岁的受害者老大爷也来了，身子骨看着挺硬朗，就是耳朵背，</p>\n" +
            "<p>我向法官介绍了认罪协议的情况，辩护律师说没有异议，并补充了一下老太太精神状况的背景，</p>\n" +
            "<p>法官又再三嘱咐到，缓刑期间要好好吃药，按缓刑官要求接收心理咨询和治疗，别舞刀弄剑的。</p>\n" +
            "<p>最后法官告诉老大爷，作为受害者，你有权在庭上做陈述</p>\n" +
            "<p>&ldquo;啊？！&rdquo;</p>\n" +
            "<p>&ldquo;您有什么要对我说的吗？&rdquo;</p>\n" +
            "<p>&ldquo;我听不见！！&rdquo;</p>\n" +
            "<p>法官示意老大爷上前，老大爷迈起步子就走上前来，没想到脚下被放各种电线的槽绊了一下，一个趔趄，单腿跪倒在地上。</p>\n" +
            "<p>我当时脑子转了好多念头，还在想美国的大爷摔倒了能不能扶，</p>\n" +
            "<p>辩护律师手里抱着文件，赶忙把文件放在地上就要去扶大爷，</p>\n" +
            "<p>但还是没有老太太动作快，直接抢上去把老大爷扶住了，</p>\n" +
            "<p>&ldquo;你为什么要报警？！&rdquo;老太太一下子眼泪就下来了，</p>\n" +
            "<p>&ldquo;啊？！！！&rdquo;</p>\n" +
            "<p>&ldquo;你为什么要叫警察抓我！&rdquo;</p>\n" +
            "<p>&ldquo;不是我叫的！！&rdquo;</p>\n" +
            "<p>&rdquo;法官，到底是不是他叫的警察&ldquo;</p>\n" +
            "<p>法官摇摇头，我也摇摇头，</p>\n" +
            "<p>&ldquo;回家吧&rdquo;老大爷说，</p>\n" +
            "<p>....</p>\n" +
            "<p>&ldquo;回家吧，我爱你啊，我怎么会伤害你呢&ldquo;</p>\n" +
            "<p>法庭后面长椅上，其他等候听证的人之中，有人长长吹了声口哨，</p>\n" +
            "<p>&rdquo;回家以后你要好好吃药，他们说了，你不吃药的话我就真叫警察来抓你了\"</p>\n" +
            "<p>\"好！！！&rdquo; 老太太对着老大爷的耳朵吼</p>\n" +
            "<p>两人手牵手离去的时候，我对老大爷喊道：&ldquo;祝你们幸福！&rdquo;</p>\n" +
            "<p>&ldquo;啊？！！！&rdquo;</p>\n" +
            "<p>&ldquo;GOOOOOD LUUUUUCK！&rdquo;</p>\n" +
            "<p>&ldquo;啊？！！&rdquo;</p>\n" +
            "<p>法官歪着脑袋说，爱情真是件奇怪的东西啊。</p>\n" +
            "<p>--</p>\n" +
            "<p>对了，两人是四年前才认识的，大爷是老太太的房东，</p>\n" +
            "<p>爱情真的是说来就来就像龙卷风。</p>\n" +
            "</div>\n" +
            "</div>\n" +
            "\n" +
            "\n" +
            "<div class=\"view-more\"><a href=\"http://www.zhihu.com/question/51299107\">查看知乎讨论<span class=\"js-question-holder\"></span></a></div>\n" +
            "\n" +
            "</div>\n" +
            "\n" +
            "\n" +
            "</div>\n" +
            "</div>";

    public static WebViewFragment newInstance() {
        WebViewFragment scrollViewFragment = new WebViewFragment();
        return scrollViewFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_webview_scrollablelayout, container, false);
        mAddressEdt = (EditText) view.findViewById(R.id.addressEdt);
        view.findViewById(R.id.goBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl(mAddressEdt.getText().toString());
            }
        });
        webView = (WebView) view.findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setAllowContentAccess(true);
        webView.getSettings().setAppCacheEnabled(true);
        webView.getSettings().setDisplayZoomControls(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);//适应屏幕，内容将自动缩放
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
//        webView.loadUrl("https://github.com/cpoopc");
        webView.loadDataWithBaseURL(null, htmlStr, "text/html", "utf-8", null);

        return view;
    }

    @Override
    public View getScrollableView() {
        return webView;
    }
}
