function SetCwinHeight(iframeId) {
	var ifr = document.getElementById(iframeId); // iframe id
	if (document.getElementById) {
		if (ifr && !window.opera) {
			if (ifr.contentDocument && ifr.contentDocument.body.offsetHeight) {
				ifr.height = ifr.contentDocument.body.offsetHeight;
			} else if (ifr.Document && ifr.Document.body.scrollHeight) {
				ifr.height = ifr.Document.body.scrollHeight;
			}
		}
	}
}

function setIframeSrc (iframeId,newSrc){
	document.getElementById(iframeId).src=newSrc;
}