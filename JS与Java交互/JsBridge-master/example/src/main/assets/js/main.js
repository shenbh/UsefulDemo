	var clientWidth;
	function resize() {
        clientWidth = document.documentElement.clientWidth;
        document.documentElement.style.fontSize = 100 * (clientWidth / 320) + 'px';
    }
    resize();
    window.addEventListener('resize', resize);

