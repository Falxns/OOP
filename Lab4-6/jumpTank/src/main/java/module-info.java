import sample.IServ;

module jumpTank {
    requires core;
    requires javafx.controls;
    exports JumpTank;

    provides IServ with JumpTank.JumpTank;
}