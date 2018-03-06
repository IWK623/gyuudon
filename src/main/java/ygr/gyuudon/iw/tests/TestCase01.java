package ygr.gyuudon.iw.tests;

/**
 * @file TestCase01
 * @brief (http://kan-kikuchi.hatenablog.com/entry/PerlinNoise)より参照したコード。多分一番シンプル
 * @author k6!
 */

import cn.nukkit.block.Block;
import cn.nukkit.level.Level;
import cn.nukkit.math.Vector3;

public class TestCase01{

  //! seed値
  private float _seedX, _seedZ;

  //! 最大高度
  private float _maxHeight = 10;

  //! 形状の険しさ
  private float _relief = (float) 15.0;

  /**
   * 
   * @brief パーリンノイズをつかった地形の生成
   * @param level 生成するワールド 
   * @param sx 生成開始のx座標
   * @param sz 生成開始のz座標
   * @param ex 生成終了のx座標
   * @param ez 生成終了のz座標　
   * @return なし
   */
  public TestCase01 (Level level, int sx, int sz, int ex, int ez) {

    //Seedの生成
    _seedX = (float) (Math.random() * 100f);
    _seedZ = (float) (Math.random() * 100f);
    	
    for(int x = sx; x <= ex; x++) {
    	for(int z = sz; z <= ez; z++) {
    		this.Set(level, x, z);
        }
    }
  }
  

  private void Set(Level level,int x,int z){
    float y = 0;

    float xSample = (x + _seedX) / _relief;
    float zSample = (z + _seedZ) / _relief;
    
    //パーリンノイズは 0.0 ~ 1.0 の値を返す
    float noise = (float) Noise.noise(xSample, y, zSample);

    y = _maxHeight * noise;


    for(;y >= 0; y--) {
        if(y > _maxHeight * 0.3f){
            level.setBlock(new Vector3(x,y,z),Block.get(Block.DIRT));
          }
          else {
            level.setBlock(new Vector3(x,y,z),Block.get(Block.STONE));
        }    	
    }

    

  }

}