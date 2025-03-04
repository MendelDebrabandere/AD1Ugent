package Week3.GameOfLife;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class SimpleTest {

    @Test
    public void testBeeHive() {
        // A bee hive is a "still life": a pattern that remains stable.
        /// ......
        /// ..##..
        /// .#..#.
        /// ..##..
        /// ......
        GameOfLife game = new MyGameOfLife(5, 6);

        String beehive = """
                        ......
                        ..OO..
                        .O..O.
                        ..OO..
                        ......
                        """;

        game.fromString(beehive, 0, 0);
        Assert.assertEquals(6, game.countAlive());
        for (int i = 0; i < 10; i++) {
            game.evolve(1);
            Assert.assertEquals(beehive, game.asString());
            Assert.assertEquals("Generation " + i, 6, game.countAlive());

            boolean[][] board = game.getBoard();
            Assert.assertTrue(board[1][2]);
            Assert.assertTrue(board[1][3]);
            Assert.assertTrue(board[2][1]);
            Assert.assertTrue(board[2][4]);
            Assert.assertTrue(board[3][2]);
            Assert.assertTrue(board[3][3]);
        }

    }

    @Test
    public void testBlinker() {
        // A blinker is a "period 2 oscillator": a pattern that repeats itself every 2 generations.
        GameOfLife game = new MyGameOfLife(6, 5);
        game.fromString(
        """
               .....
               ..O..
               ..O..
               ..O..
               .....
               """,
        0,
        0
        );

        Assert.assertEquals(3, game.countAlive());

        game.evolve(1);
        Assert.assertEquals(3, game.countAlive());

        boolean[][] board = game.getBoard();
        Assert.assertTrue(board[2][1]);
        Assert.assertTrue(board[2][2]);
        Assert.assertTrue(board[2][3]);

        game.evolve(1);
        Assert.assertEquals(3, game.countAlive());

        board = game.getBoard();
        Assert.assertTrue(board[1][2]);
        Assert.assertTrue(board[2][2]);
        Assert.assertTrue(board[3][2]);
    }

    @Test
    public void testGlider() {
        // A glider is a "spaceship": a pattern that moves across the board.
        /// .....
        /// ..#..
        /// ...#.
        /// .###.

        GameOfLife game = new MyGameOfLife(10, 20);

        game.fromString(
                """
                       .....
                       ..O..
                       ...O.
                       .OOO.
                       """,
                0,
                0
        );
        Assert.assertEquals(5, game.countAlive());

        game.evolve(2);
        Assert.assertEquals(5, game.countAlive());

        boolean[][] board = game.getBoard();
        Assert.assertTrue(board[2][3]);
        Assert.assertTrue(board[3][1]);
        Assert.assertTrue(board[3][3]);
        Assert.assertTrue(board[4][2]);
        Assert.assertTrue(board[4][3]);

        game.evolve(2);
        Assert.assertEquals(5, game.countAlive());

        board = game.getBoard();
        Assert.assertTrue(board[2][3]);
        Assert.assertTrue(board[3][4]);
        Assert.assertTrue(board[4][2]);
        Assert.assertTrue(board[4][3]);
        Assert.assertTrue(board[4][4]);

        game.evolve(30);
        // The glider stabilizes at the edge of the board in a 2x2 square.
        Assert.assertEquals(4, game.countAlive());
    }

    @Test
    public void testQueenBee() {
        //// Queen Bee is a pattern that ultimatelly settles in six blocks and
        /// two blinkers. The main challenge to this test is the large board.
        GameOfLife game = new MyGameOfLife(2000, 2000);
        game.fromString(
    """
           ...O...
           ..O.O..
           .O...O.
           ..OOO..
           OO...OO
           """,
           1000,
           1000
        );


        game.evolve(191);

        Assert.assertEquals(30, game.countAlive());
        game.evolve(1);
        Assert.assertEquals(30, game.countAlive());
    }

    @Test
    public void testRPentomino() {
        //// The "R-pentomino" is a small pattern that takes 1103 generations to
        /// stabilize at a final population of 116.
        /// .....
        /// .##..
        /// ..##.
        /// ..#..
        /// .....

        GameOfLife game = new MyGameOfLife(200, 200);
        game.fromString(
                """
                        .....
                        .OO..
                        ..OO.
                        ..O..
                        """,
                100,
                100
        );

        // This can take a while if not implemented efficiently.
        game.evolve(1103);

        // The final population of 116 includes 6 gliders who would keep going
        // if the board was infinite. In our case, they are stopped by the
        // edge of the board and stabilize in a 2x2 square which has 4 alive
        // cells (the glider has 5).
        Assert.assertEquals(116 - 6, game.countAlive());

        game.evolve(1);
        Assert.assertEquals(116 - 6, game.countAlive());
    }

    @Test
    @Ignore("This test takes a while. Aim for 2 seconds or less.")
    public void testAcorn() {
        // The "acorn" is a pattern that takes 5206 generations to stabilize at a
        // final population of 633 which reminds of an oak tree.
        /// .........
        /// ..#......
        /// ....#....
        /// .##..###.
        /// .........

        GameOfLife game = new MyGameOfLife(500, 500);
        game.fromString(
                """
                        ..........
                        ..O.......
                        ....O.....
                        .OO..OOO..
                        .........
                        """,
                210,
                210
        );

        // This can take a while if not implemented efficiently.
        game.evolve(5206);

        // The final population of 633 includes 13 gliders who would keep going
        // if the board was infinite. In our case, they are stopped by the
        // edge of the board and stabilize in a 2x2 square which has 4 alive
        // cells (the glider has 5).
        Assert.assertEquals(633 - 13, game.countAlive());

        game.evolve(1);
        Assert.assertEquals(633 - 13, game.countAlive());
    }
}
