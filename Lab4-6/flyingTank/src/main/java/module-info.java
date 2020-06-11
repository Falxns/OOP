import sample.IServ;

module flyingTank {
    requires core;
    requires javafx.controls;
    exports FlyingTank;

    provides IServ with FlyingTank.FlyingTank;
}