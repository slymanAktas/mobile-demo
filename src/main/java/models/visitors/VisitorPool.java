package models.visitors;

import base.TestContext;

public class VisitorPool {
    private VisitorPool() {
    }

    public static Visitor with(String email, String password) {
        Visitor visitor = new Visitor(email, password);
        TestContext.get().addVisitor(visitor);
        return visitor;
    }

    public static Visitor anonymous() {
        return with("", "");
    }
}
