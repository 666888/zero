<!DOCTYPE html>
<html>
<head>
<title>Subic Admin</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->
<link href="../../../static/gm/css/bootstrap.css" rel="stylesheet" media="screen">
<link href="../../../static/gm/css/thin-admin.css" rel="stylesheet" media="screen">
<link href="../../../static/gm/css/font-awesome.css" rel="stylesheet" media="screen">
<link href="../../../static/gm/style/style.css" rel="stylesheet">
<link href="../../../static/gm/style/dashboard.css" rel="stylesheet">
<link href="../../../static/gm/assets/jquery-easy-pie-chart/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css" media="screen"/>
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="../../assets/js/html5shiv.js"></script>
      <script src="../../assets/js/respond.min.js"></script>
    <![endif]-->

</head>
<body>
<div class="container">
  <div class="top-navbar header b-b"> <a data-original-title="Toggle navigation" class="toggle-side-nav pull-left" href="#"><i class="icon-reorder"></i> </a>
    <div class="brand pull-left"> <a href="index.html"><img src="images/logo.png" width="147" height="33"></a></div>
    <ul class="nav navbar-nav navbar-right  hidden-xs">
      <li class="dropdown"> <a data-toggle="dropdown" class="dropdown-toggle" href="#"> <i class="icon-warning-sign"></i> <span class="badge">5</span> </a>
        <ul class="dropdown-menu extended notification">
          <li class="title">
            <p>You have 5 new notifications</p>
          </li>
          <li> <a href="#"> <span class="label label-success"><i class="icon-plus"></i></span> <span class="message">New user registration.</span> <span class="time">1 mins</span> </a> </li>
          <li> <a href="#"> <span class="label label-danger"><i class="icon-warning-sign"></i></span> <span class="message">High CPU load on cluster #2.</span> <span class="time">5 mins</span> </a> </li>
          <li> <a href="#"> <span class="label label-success"><i class="icon-plus"></i></span> <span class="message">New user registration.</span> <span class="time">10 mins</span> </a> </li>
          <li> <a href="#"> <span class="label label-info"><i class="icon-bullhorn"></i></span> <span class="message">New items are in queue.</span> <span class="time">25 mins</span> </a> </li>
          <li> <a href="#"> <span class="label label-warning"><i class="icon-bolt"></i></span> <span class="message">Disk space to 85% full.</span> <span class="time">35 mins</span> </a> </li>
          <li class="footer"> <a href="#">View all notifications</a> </li>
        </ul>
      </li>
      <li class="dropdown"> <a data-toggle="dropdown" class="dropdown-toggle" href="#"> <i class="icon-tasks"></i> <span class="badge">7</span> </a>
        <ul class="dropdown-menu extended notification">
          <li class="title">
            <p>You have 7 pending tasks</p>
          </li>
          <li> <a href="#"> <span class="task"> <span class="desc">Preparing new release</span> <span class="percent">30%</span> </span>
            <div class="progress progress-small">
              <div class="progress-bar progress-bar-info" style="width: 30%;"></div>
            </div>
            </a> </li>
          <li> <a href="#"> <span class="task"> <span class="desc">Change management</span> <span class="percent">80%</span> </span>
            <div class="progress progress-small progress-striped active">
              <div class="progress-bar progress-bar-danger" style="width: 80%;"></div>
            </div>
            </a> </li>
          <li> <a href="#"> <span class="task"> <span class="desc">Mobile development</span> <span class="percent">60%</span> </span>
            <div class="progress progress-small">
              <div class="progress-bar progress-bar-success" style="width: 60%;"></div>
            </div>
            </a> </li>
          <li> <a href="#"> <span class="task"> <span class="desc">Database migration</span> <span class="percent">20%</span> </span>
            <div class="progress progress-small">
              <div class="progress-bar progress-bar-warning" style="width: 20%;"></div>
            </div>
            </a> </li>
          <li class="footer"> <a href="#">View all tasks</a> </li>
        </ul>
      </li>
      <li class="dropdown"> <a data-toggle="dropdown" class="dropdown-toggle" href="#"> <i class="icon-envelope"></i> <span class="badge">1</span> </a>
        <ul class="dropdown-menu extended notification">
          <li class="title">
            <p>You have 3 new messages</p>
          </li>
          <li> <a href="#"> <span class="photo"> <img src="images/profile.png" width="34" height="34"></span> <span class="subject"> <span class="from">John Lee</span> <span class="time">Just Now</span> </span> <span class="text"> Consetetur sadipscing elitr...</span> </a> </li>
          <li> <a href="#"> <span class="photo"><img src="images/profile.png" width="34" height="34"></span> <span class="subject"> <span class="from">John Lee</span> <span class="time">35 mins</span> </span> <span class="text"> Sed diam nonumy... </span> </a> </li>
          <li> <a href="#"> <span class="photo"><img src="images/profile.png" width="34" height="34"></span> <span class="subject"> <span class="from">John Lee</span> <span class="time">5 hours</span> </span> <span class="text"> No sea takimata sanctus... </span> </a> </li>
          <li class="footer"> <a href="#">View all messages</a> </li>
        </ul>
      </li>
      <li class="dropdown user  hidden-xs"> <a data-toggle="dropdown" class="dropdown-toggle" href="#"> <i class="icon-male"></i> <span class="username">John Lee</span> <i class="icon-caret-down small"></i> </a>
        <ul class="dropdown-menu">
          <li><a href="user_profile.html"><i class="icon-user"></i> My Profile</a></li>
          <li><a href="fullCalendar.html"><i class="icon-calendar"></i> My Calendar</a></li>
          <li><a href="#"><i class="icon-tasks"></i> My Tasks</a></li>
          <li class="divider"></li>
          <li><a href="login.html"><i class="icon-key"></i> Log Out</a></li>
        </ul>
      </li>
    </ul>
    <form class="pull-right" >
      <input type="search" placeholder="Search..." class="search" id="search-input">
    </form>
  </div>
</div>
<div class="wrapper">
 
  <div class="page-content">
    <div class="content container">
      <div class="row">
        <div class="col-lg-12">
          <h2 class="page-title">Dashboard <small>Statistics and more</small></h2>
        </div>
      </div>
      <div class="row">
        <div class="col-md-12">
          <div class="row">
            <div class="col-md-3 col-xs-12 col-sm-6"> <a href="#" class="stats-container">
              <div class="stats-heading">Profit</div>
              <div class="stats-body-alt"> 
               
                <div class="text-center"><span class="text-top">$</span>345</div>
                <small>+4.7% from last period</small> </div>
              <div class="stats-footer">more info</div>
              </a> </div>
            <div class="col-md-3 col-xs-12 col-sm-6"> <a href="#" class="stats-container">
              <div class="stats-heading">Revenue</div>
              <div class="stats-body-alt"> 
               
                <div class="text-center"><span class="text-top">$</span>34.7k</div>
                <small>-14.7% from last week</small> </div>
              <div class="stats-footer">go to account</div>
              </a> </div>
            <div class="col-md-3 col-xs-12 col-sm-6"> <a href="#" class="stats-container">
              <div class="stats-heading">Members</div>
              <div class="stats-body-alt"> 
               
                <div class="text-center"><span class="text-top"></span>207</div>
                <small>new user registered</small> </div>
              <div class="stats-footer">manage members</div>
              </a> </div>
            <div class="col-md-3 col-xs-12 col-sm-6"> <a href="#" class="stats-container">
              <div class="stats-heading">Orders</div>
              <div class="stats-body-alt"> 
             
                <div class="text-center"><span class="text-top">$</span>345</div>
                <small>new orders received</small> </div>
              <div class="stats-footer">manage orders</div>
              </a> </div>
          </div>
        </div>
      </div>
      
      
<div class="row">
  <div class="col-lg-4"> 
    <!--new earning start-->
    <div class="panel terques-chart">
      <div class="panel-body chart-texture">
        <div class="chart">
          <div class="heading"> <span>Friday</span> <strong>$ 48,00 | 13%</strong> </div>
          <div class="sparkline" data-type="line" data-resize="true" data-height="90" data-width="90%" data-line-width="1" data-line-color="#fff" data-spot-color="#fff" data-fill-color="" data-highlight-line-color="#fff" data-spot-radius="4" data-data="[200,135,667,333,526,996,564,123,890,564,455]"></div>
        </div>
      </div>
      <div class="chart-tittle"> <span class="title">New Earning</span> <span class="value-pie"> <a href="#" class="active">Market</a> | <a href="#">Referal</a> | <a href="#">Online</a> </span> </div>
    </div>
    <!--new earning end--> 
  </div>
  <div class="col-lg-4"> 
    <!--total earning start-->
    <div class="panel green-chart">
      <div class="panel-body">
        <div class="chart">
          <div class="heading"> <span>June</span> <strong>18 Days | 55%</strong> </div>
          <div id="barchart"></div>
        </div>
      </div>
      <div class="chart-tittle"> <span class="title">Total Earning</span> <span class="value-pie">$, 85,34,577</span> </div>
    </div>
    <!--total earning end--> 
  </div>
  <div class="col-lg-4"> 
    <!--pie chart start-->
    <div class="panel">
      <div class="panel-body text-center">
        <div class="chart" style="height: 110px;">
          <div id="pie-chart" ></div>
        </div>
      </div>
      <div class="chart-tittle"> Free: 240GB </div>
    </div>
    <!--pie chart start--> 
  </div>
</div>
 
         
    </div>
  </div>
</div>
<div class="bottom-nav footer"> 2014 &copy; Subic Admin by Zero Systems. </div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) --> 
<script type="text/javascript" src="../../../static/gm/js/jquery.js"></script> 
<script type="text/javascript" src="../../../static/gm/js/bootstrap.min.js"></script> 
<script type="text/javascript" src="../../../static/gm/js/smooth-sliding-menu.js"></script> 
<script type="text/javascript" src="../../../static/gm/javascript/jquery191.min.js"></script> 
<script type="text/javascript" src="../../../static/gm/javascript/jquery.jqplot.min.js"></script> 
<script type="text/javascript" src="../../../static/gm/assets/sparkline/jquery.sparkline.js" ></script>
<script type="text/javascript" src="../../../static/gm/assets/sparkline/jquery.customSelect.min.js" ></script>
<script type="text/javascript" src="../../../static/gm/assets/sparkline/sparkline-chart.js"></script>
<script type="text/javascript" src="../../../static/gm/assets/sparkline/easy-pie-chart.js"></script>
<script type="text/javascript" src="../../../static/gm/js/select-checkbox.js"></script> 
<script type="text/javascript" src="../../../static/gm/js/to-do-admin.js"></script> 

<!--switcher html start-->
<div class="demo_changer active" style="right: 0px;">
  <div class="demo-icon"></div>
  <div class="form_holder">
    <div class="predefined_styles"> <a class="styleswitch" rel="a" href=""><img alt="" src="../../../static/gm/images/a.jpg"></a> <a class="styleswitch" rel="b" href=""><img alt="" src="../../../static/gm/images/b.jpg"></a> <a class="styleswitch" rel="c" href=""><img alt="" src="../../../static/gm/images/c.jpg"></a> <a class="styleswitch" rel="d" href=""><img alt="" src="../../../static/gm/images/d.jpg"></a> <a class="styleswitch" rel="e" href=""><img alt="" src="../../../static/gm/images/e.jpg"></a> <a class="styleswitch" rel="f" href=""><img alt="" src="../../../static/gm/images/f.jpg"></a> <a class="styleswitch" rel="g" href=""><img alt="" src="../../../static/gm/images/g.jpg"></a> <a class="styleswitch" rel="h" href=""><img alt="" src="../../../static/gm/images/h.jpg"></a> <a class="styleswitch" rel="i" href=""><img alt="" src="../../../static/gm/images/i.jpg"></a> <a class="styleswitch" rel="j" href=""><img alt="" src="../../../static/gm/images/j.jpg"></a> </div>
  </div>
</div>

<!--switcher html end--> 
<script src="../../../static/gm/assets/switcher/switcher.js"></script> 
<script src="../../../static/gm/assets/switcher/moderziner.custom.js"></script>
<link href="../../../static/gm/assets/switcher/switcher.css" rel="stylesheet">
<link href="../../../static/gm/assets/switcher/switcher-defult.css" rel="stylesheet">
<link rel="alternate stylesheet" type="text/css" href="../../../static/gm/assets/switcher/a.css" title="a" media="all" />
<link rel="alternate stylesheet" type="text/css" href="../../../static/gm/assets/switcher/b.css" title="b" media="all" />
<link rel="alternate stylesheet" type="text/css" href="../../../static/gm/assets/switcher/c.css" title="c" media="all" />
<link rel="alternate stylesheet" type="text/css" href="../../../static/gm/assets/switcher/d.css" title="d" media="all" />
<link rel="alternate stylesheet" type="text/css" href="../../../static/gm/assets/switcher/e.css" title="e" media="all" />
<link rel="alternate stylesheet" type="text/css" href="../../../static/gm/assets/switcher/f.css" title="f" media="all" />
<link rel="alternate stylesheet" type="text/css" href="../../../static/gm/assets/switcher/g.css" title="g" media="all" />
<link rel="alternate stylesheet" type="text/css" href="../../../static/gm/assets/switcher/h.css" title="h" media="all" />
<link rel="alternate stylesheet" type="text/css" href="../../../static/gm/assets/switcher/i.css" title="i" media="all" />
<link rel="alternate stylesheet" type="text/css" href="../../../static/gm/assets/switcher/j.css" title="j" media="all" />



</body>
</html>
