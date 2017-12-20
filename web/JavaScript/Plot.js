var Height=600;
var Width=600;
var oldR=2.0;
var rScale=50;

function redraw(r){
    var graph = document.getElementById("graph"),
        ctx = graph.getContext('2d');
    graph.height = Height;
    graph.width  = Width;
    ctx.fillStyle="white";
    ctx.fillRect(0,0,Width,Height);
    for(var i=rScale;i<Width/2;i+=rScale){
        ctx.beginPath();
        ctx.moveTo(Width/2+i,0);
        ctx.lineTo(Width/2+i,Height);
        ctx.stroke();
        ctx.closePath();
        ctx.beginPath();
        ctx.moveTo(0,Height/2+i);
        ctx.lineTo(Width,Height/2+i);
        ctx.stroke();
        ctx.closePath();
        ctx.beginPath();
        ctx.moveTo(0,Height/2-i);
        ctx.lineTo(Width,Height/2-i);
        ctx.stroke();
        ctx.closePath();
        ctx.beginPath();
        ctx.moveTo(Width/2-i,0);
        ctx.lineTo(Width/2-i,Height);
        ctx.stroke();
        ctx.closePath();
    }
    ctx.fillStyle="blue";
    ctx.beginPath();
    ctx.lineWidth=3;
    ctx.moveTo(graph.width/2,0);
    ctx.lineTo(graph.width/2,graph.height);
    ctx.moveTo(0,graph.height/2);
    ctx.lineTo(graph.width,graph.height/2);
    ctx.stroke();
    ctx.closePath()
    ctx.strokeStyle="blue";
    //square
    ctx.strokeRect(graph.width/2,graph.height/2-r*rScale,r*rScale,r*rScale);
    //triangle
    ctx.beginPath();
    ctx.moveTo(graph.width/2,graph.height/2);
    ctx.lineTo(graph.width/2-r*rScale,graph.height/2);
    ctx.lineTo(graph.width/2,graph.height/2+r*rScale);
    ctx.closePath();
    ctx.stroke();
    ctx.beginPath();
    //circle
    ctx.arc(graph.width/2,graph.height/2,r*rScale/2,0,Math.PI/2,false);
    ctx.stroke();
    ctx.closePath();
}

function drawPoint(x, y, result) {
    x = x * rScale + Width/2;
    y = Height/2 - y * rScale;
    var canvas = document.getElementById("graph");
    var ctx = canvas.getContext("2d");
    var pi = Math.PI;
    ctx.beginPath();
    if (result == "true"){
        ctx.fillStyle = "green";
        ctx.strokeStyle = "green";
    }
    else {
        ctx.fillStyle = "red";
        ctx.strokeStyle = "red";
    }
    ctx.arc(x, y, 3, 0, 2*pi);
    ctx.stroke();
    ctx.fill();
    ctx.closePath();

}

function getPoint() {
    var canvas = document.getElementById("graph");
    canvas.onclick = function (event) {
        var x = event.clientX - canvas.getBoundingClientRect().left;
        var y = event.clientY - canvas.getBoundingClientRect().top;
        var r = document.getElementById("j_idt5:varR").value;
        sendPoint(x, y, r);
    }
}

function drawPoints() {
    redraw(document.getElementById("j_idt5:varR").value);
    var res_table = document.getElementById("resTable");
    for (var i = 1; i < res_table.rows.length; i++) {
        drawPoint(res_table.rows[i].cells[0].textContent, res_table.rows[i].cells[1].textContent, res_table.rows[i].cells[2].textContent);
    }
    getPoint();
}

function sendPoint(x, y, r) {
    var resX = Math.round((x - Width/2) / rScale);
    var resY = (Height/2 - y) / rScale;
    document.getElementById("j_idt5:varX").setAttribute("value","1");
    document.getElementById("j_idt5:varY").value = resY;
    document.getElementById("j_idt5:ajax").click();
}

getPoint();