import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import javax.swing.*;

public class PacMan extends JPanel implements ActionListener, KeyListener{

    class Block{
        int x;
        int y;
        int width;
        int height;
        int startX;
        int startY;
        Image image;
        char direction = 'U';
        int velocityX = 0;
        int velocityY = 0;

        public Block(Image image, int x, int y, int width, int height){
            this.image = image;
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.startX = x;
            this.startY = y;
        }

        public void updatePosition(char direction){
            char previousDirection = this.direction;
            this.direction = direction;
            switch(this.direction){
                case 'U':
                    this.velocityX = 0;
                    this.velocityY = -tileSize/4;
                    break;
                case 'D':
                    this.velocityX = 0;
                    this.velocityY = tileSize/4;
                    break;
                case 'L':
                    this.velocityX = -tileSize/4;
                    this.velocityY = 0;
                    break;
                case 'R':
                    this.velocityX = tileSize/4;
                    this.velocityY = 0;
                    break;
            }
            this.x += this.velocityX;
            this.y += this.velocityY;
            for(Block wall : walls){
                if(collision(this, wall)){
                    this.x -= this.velocityX;
                    this.y -= this.velocityY;
                    this.direction = previousDirection;
                    switch(this.direction){
                case 'U':
                    this.velocityX = 0;
                    this.velocityY = -tileSize/4;
                    break;
                case 'D':
                    this.velocityX = 0;
                    this.velocityY = tileSize/4;
                    break;
                case 'L':
                    this.velocityX = -tileSize/4;
                    this.velocityY = 0;
                    break;
                case 'R':
                    this.velocityX = tileSize/4;
                    this.velocityY = 0;
                    break;
            }
                }
            }
        }
    }
    int rowCount = 21;
    int columnCount = 19;
    int tileSize = 32;
    int boardWidth = columnCount * tileSize;
    int boardHeight = rowCount * tileSize;

    private Image wallImage;
    private Image blueGhost;
    private Image orangeGhost;
    private Image pinkGhost;
    private Image redGhost;
    private Image pacManUp;
    private Image pacManDown;
    private Image pacManLeft;
    private Image pacManRight;
    private Image powerFood;

    private Set<Block> walls;
    private Set<Block> foods;
    private Set<Block> ghosts;
    Block pacman;
    Timer gameLoop;
    char[] directions = {'U', 'D', 'L', 'R'};
    Random random = new Random();
    int score = 0;
    boolean gameOver = false;
    int lives = 3;
    
    //X = wall, O = skip, P = pac man, ' ' = food
    //Ghosts: b = blue, o = orange, p = pink, r = red
    private String[] tileMap = {
        "XXXXXXXXXXXXXXXXXXX",
        "X        X        X",
        "X XX XXX X XXX XX X",
        "X                 X",
        "X XX X XXXXX X XX X",
        "X    X       X    X",
        "XXXX XXXX XXXX XXXX",
        "OOOX X       X XOOO",
        "XXXX X XXrXX X XXXX",
        "O       bpo       O",
        "XXXX X XXXXX X XXXX",
        "OOOX X       X XOOO",
        "XXXX X XXXXX X XXXX",
        "X        X        X",
        "X XX XXX X XXX XX X",
        "X  X     P     X  X",
        "XX X X XXXXX X X XX",
        "X    X   X   X    X",
        "X XXXXXX X XXXXXX X",
        "X                 X",
        "XXXXXXXXXXXXXXXXXXX" 
    };




    PacMan(){
        walls = new HashSet<>();
        foods = new HashSet<>();
        ghosts = new HashSet<>();
        pacman = null;
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        setBackground(Color.BLACK);
        addKeyListener(this);
        setFocusable(true);


        wallImage = new ImageIcon(getClass().getResource("./wall.png")).getImage();
        pacManUp = new ImageIcon(getClass().getResource("./pacmanUp.png")).getImage();
        pacManDown = new ImageIcon(getClass().getResource("./pacmanDown.png")).getImage();
        pacManLeft = new ImageIcon(getClass().getResource("./pacmanLeft.png")).getImage();
        pacManRight = new ImageIcon(getClass().getResource("./pacmanRight.png")).getImage();
        blueGhost = new ImageIcon(getClass().getResource("./blueGhost.png")).getImage();
        redGhost = new ImageIcon(getClass().getResource("./redGhost.png")).getImage();
        orangeGhost = new ImageIcon(getClass().getResource("./orangeGhost.png")).getImage();
        pinkGhost = new ImageIcon(getClass().getResource("./pinkGhost.png")).getImage();
        powerFood = new ImageIcon(getClass().getResource("./powerFood.png")).getImage();
        setTileMap(tileMap);
        for(Block ghost : ghosts){
            char newDirection = directions[random.nextInt(4)];
            ghost.updatePosition(newDirection);

        }
        gameLoop = new Timer(50, this);
        gameLoop.start();

    }

    public void setTileMap(String[] tileMap){
        for(int r = 0; r < rowCount; r++){
            for(int c = 0; c < columnCount; c++){
                String row = tileMap[r];
                char tileType = row.charAt(c);
                int x = c*tileSize;
                int y = r*tileSize;

                switch(tileType){
                    case 'X':
                        Block wall = new Block(wallImage, x, y, tileSize, tileSize);
                        walls.add(wall);
                        break;
                    case 'b':
                        Block blue = new Block(blueGhost, x, y, tileSize, tileSize);
                        ghosts.add(blue);
                        break;
                    case 'o':
                        Block orange = new Block(orangeGhost, x, y, tileSize, tileSize);
                        ghosts.add(orange);
                        break;
                    case 'p':
                        Block pink = new Block(pinkGhost, x, y, tileSize, tileSize);
                        ghosts.add(pink);
                        break;
                    case 'r':
                        Block red = new Block(redGhost, x, y, tileSize, tileSize);
                        ghosts.add(red);
                        break;
                    case 'P':
                        Block pacManBlock = new Block(pacManRight, x, y, tileSize, tileSize);
                        pacman = pacManBlock;
                        break;
                    case ' ':
                        Block food = new Block(powerFood, x + 14, y + 14, 4,4);
                        foods.add(food);
                        break;


                }

            }
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g){
        g.drawImage(pacman.image, pacman.x, pacman.y, pacman.width, pacman.height, null);
     for(Block wall : walls){
        g.drawImage(wall.image, wall.x, wall.y, wall.width, wall.height, null);
    }
    for(Block food : foods){
        g.drawImage(food.image, food.x, food.y, food.width, food.height, null);
    }
    for(Block ghost : ghosts){
        g.drawImage(ghost.image, ghost.x, ghost.y, ghost.width, ghost.height, null);
    }
    g.setFont(new Font("Arial", Font.PLAIN, 20));
    if(gameOver){
        g.drawString("GAME OVER: " + String.valueOf(score), tileSize/2, tileSize/2);
    }else{
        g.drawString("x" + String.valueOf(lives) + "SCORE: " + String.valueOf(score), tileSize/2, tileSize/2);
    }
    

}

public void move(){
    pacman.x += pacman.velocityX;
    pacman.y += pacman.velocityY;

    for(Block ghost : ghosts){
        if(ghost.y == tileSize*9 && ghost.x == tileSize*9){
            ghost.updatePosition('U');
        }
        ghost.x += ghost.velocityX;
        ghost.y += ghost.velocityY;
        for(Block wall : walls){
            if(collision(ghost, wall) || ghost.x <= 0 || ghost.x + ghost.width >= boardWidth){
                ghost.x -= ghost.velocityX;
                ghost.y -= ghost.velocityY;
                char newDirection = directions[random.nextInt(4)];
                ghost.updatePosition(newDirection);
                break;
            }
        }
    }

    for(Block wall : walls){
        if(collision(pacman, wall)){
            pacman.x -= pacman.velocityX;
            pacman.y -= pacman.velocityY;
            break;
        }
    }
    
    Block eatenFood = null;
    for(Block food : foods){
        if(collision(pacman, food)){
            eatenFood = food;
            score += 10;
        }
    }
    if(eatenFood != null){
        foods.remove(eatenFood);
    }
    
    for(Block ghost : ghosts){
        if(collision(pacman, ghost)){
            lives--;
            if(lives == 0){
                gameOver = true;
                return;
            }
            resetPositions();
        }
    }
}

public boolean collision(Block a, Block b){
    return (a.x < b.x + b.width &&
            a.x + a.width > b.x &&
            a.y < b.y + b.height &&
            a.y + a.height > b.y);
}

public void resetPositions(){
    pacman.x = pacman.startX;
    pacman.y = pacman.startY;
    pacman.velocityX = 0;
    pacman.velocityY = 0;
    
    for(Block ghost : ghosts){
        ghost.x = ghost.startX;
        ghost.y = ghost.startY;
        char newDirection = directions[random.nextInt(4)];
        ghost.updatePosition(newDirection);
    }
}

    @Override
    public void actionPerformed(ActionEvent e) {
       move();
       repaint();
}

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        switch(e.getKeyCode()){
            case KeyEvent.VK_UP:
                pacman.updatePosition('U');
                break;
            case KeyEvent.VK_DOWN:
                pacman.updatePosition('D');
                break;
            case KeyEvent.VK_LEFT:
                pacman.updatePosition('L');
                break;
            case KeyEvent.VK_RIGHT:
                pacman.updatePosition('R');
                break;
        }
        switch(pacman.direction){
            case 'U':
               pacman.image = pacManUp;
               break;
            case 'D':
                pacman.image = pacManDown;
                break;
            case 'L':
                pacman.image = pacManLeft;
                break;
            case 'R':
                pacman.image = pacManRight;
                break;
        }
    }
}
