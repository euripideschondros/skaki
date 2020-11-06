/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gamejava;

/**
 *
 * @author akis
 */
public class Pawn extends Piece {

    public Pawn(Location loc, Board x, ColorEnum color) {
        super(loc, x, color);

    }

    @Override
    void moveTo(Location loc1) throws Exception {
        boolean flag = false;
        if (color == ColorEnum.BLACK) {
            if (loc.r == 1) {
                if (loc1.c == loc.c) {
                    int a;
                    a = loc.r - loc1.r;
                    if (a >= -2 && a < 0) {
                        flag = x.freeVerticalPath(loc, loc1);
                        if (flag) {
                            System.out.println("TRUEEEE");
                            if (x.matrix[loc1.r][loc1.c] == null) {
                                x.movePiece(loc, loc1);
                                return;
                            }
                            throw new Exception("Wrong Input");
                        } else {
                            System.out.println("FALSEEE");
                            throw new Exception("Wrong Input");
                        }
                    } else {
                        throw new Exception("Wrong Input");
                    }
                } else if (Math.abs(loc.c - loc1.c) == 1 && Math.abs(loc.r - loc1.r) == 1) {
                    if (x.matrix[loc1.r][loc1.c] != null) {
                        if (x.matrix[loc1.r][loc1.c].color != color) {
                            x.movePiece(loc, loc1);
                            return;
                        }
                    }
                    throw new Exception("Wrong Input");
                } else {
                    throw new Exception("Wrong Input");
                }
            } else {
                if (loc1.c == loc.c) {
                    int a;
                    a = loc.r - loc1.r;
                    if (a == -1) {
                            if (x.matrix[loc1.r][loc1.c] == null) {
                                x.movePiece(loc, loc1);
                                return;
                            }
                            throw new Exception("Wrong Input");
                    } else {
                        throw new Exception("Wrong Input");
                    }
                } else if (Math.abs(loc.c - loc1.c) == 1 && Math.abs(loc.r - loc1.r) == 1) {
                    if (x.matrix[loc1.r][loc1.c] != null) {
                        if (x.matrix[loc1.r][loc1.c].color != color) {
                            x.movePiece(loc, loc1);
                            return;
                        }
                    }
                    throw new Exception("Wrong Input");
                } else {
                    throw new Exception("Wrong Input");
                }
            }
        } else {
            //WHITE
            if (loc.r == 6) {
                if (loc1.c == loc.c) {
                    int a;
                    a = loc.r - loc1.r;
                    if (a <= 2 && a > 0) {
                        flag = x.freeVerticalPath(loc, loc1);
                        if (flag) {
                            if (x.matrix[loc1.r][loc1.c] == null) {
                                x.movePiece(loc, loc1);
                                return;
                            }
                            throw new Exception("Wrong Input");
                        } else {
                            throw new Exception("Wrong Input");
                        }
                    } else {
                        throw new Exception("Wrong Input");
                    }
                } else if (Math.abs(loc.c - loc1.c) == 1 && Math.abs(loc.r - loc1.r) == 1) {
                    if (x.matrix[loc1.r][loc1.c] != null) {
                        if (x.matrix[loc1.r][loc1.c].color != color) {
                            x.movePiece(loc, loc1);
                            return;
                        }
                        throw new Exception("Wrong Input");
                    }
                    throw new Exception("Wrong Input");
                } else {
                    throw new Exception("Wrong Input");
                }
            } else {
                if (loc1.c == loc.c) {
                    int a;
                    a = loc.r - loc1.r;
                    if (a == 1) {
                            if (x.matrix[loc1.r][loc1.c] == null) {
                                x.movePiece(loc, loc1);
                                return;
                            }
                            throw new Exception("Wrong Input");
                    } else {
                        throw new Exception("Wrong Input");
                    }
                } else if (Math.abs(loc.c - loc1.c) == 1 && Math.abs(loc.r - loc1.r) == 1) {
                    if (x.matrix[loc1.r][loc1.c] != null) {
                        if (x.matrix[loc1.r][loc1.c].color != color) {
                            x.movePiece(loc, loc1);
                            return;
                        }
                    }
                    throw new Exception("Wrong Input");
                } else {
                    throw new Exception("Wrong Input");
                }
            }
        }
    }

    @Override
    public String toString() {
        if (color == ColorEnum.BLACK) {
            return "p";




        } else {
            return "P";


        }

    }
}
